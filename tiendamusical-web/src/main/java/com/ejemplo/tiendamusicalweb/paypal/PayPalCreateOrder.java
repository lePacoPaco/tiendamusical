/**
 * 
 */
package com.ejemplo.tiendamusicalweb.paypal;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ejemplo.tiendamusicalentities.entities.CarritoAlbum;
import com.ejemplo.tiendamusicalweb.session.SessionBean;
import com.google.gson.Gson;
import com.paypal.http.HttpResponse;
import com.paypal.orders.AddressPortable;
import com.paypal.orders.AmountBreakdown;
import com.paypal.orders.AmountWithBreakdown;
import com.paypal.orders.ApplicationContext;
import com.paypal.orders.Item;
import com.paypal.orders.Money;
import com.paypal.orders.Name;
import com.paypal.orders.Order;
import com.paypal.orders.OrderRequest;
import com.paypal.orders.OrdersCreateRequest;
import com.paypal.orders.Payer;
import com.paypal.orders.PurchaseUnitRequest;
import com.paypal.orders.ShippingDetail;

/**
 * @author paco_ 
 * Clase que se encarga de generar la estructura y la orden de la
 * información de la compra que desea realizar el usuario en PayPal.
 */
public class PayPalCreateOrder extends PayPalClient {

	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o
	 * en el archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(PayPalCreateOrder.class);
	
	/**
	 * Objeto que contiene la orden de pago de compra.
	 */
	private OrderRequest orderRequest;

	/**
	 * Método que se encarga de generar la orden de compra de los productos para el
	 * botón de PayPal
	 * 
	 * @param sessionBean {@link SessionBean} objeto con la información del carrito
	 *                    del usuario en sesión.
	 * @return {@link HttpResponse} objeto que obtiene una respuesta HTTP del
	 *         servicio de PayPal.
	 * @throws IOException {@link IOException} Excepcion en caso de error al generar la transacción de compra con PayPal.  
	 */
	public HttpResponse<Order> crearOrden(SessionBean sessionBean) throws IOException {
		LOGGER.info("Ingresando a la función de crearOrden...");
		OrdersCreateRequest ordersCreateRequest = new OrdersCreateRequest();
		ordersCreateRequest.prefer("return=representation");
		ordersCreateRequest.requestBody(this.generarCuerpoOrden(sessionBean));
		
		HttpResponse<Order> response = client().execute(ordersCreateRequest);
		
		sessionBean.setOrder(response);
		
		return response;
	}

	/**
	 * Método que permite generar el cuerpo de la información 
	 * del formulario de Pago de PAyPal con el detalle de toda la transacción
	 * @param sessionBean {@link SessionBean} objeto con la información en sesión de los productos del carrito.
	 * @return {@link OrderRequest} objeto con la solicitud de la orden de compra.
	 */
	private OrderRequest generarCuerpoOrden(SessionBean sessionBean) {
		// Se genera el objeto de solicitud de la orden a mostrar con la información del
		// carrito en PayPal.
		this.orderRequest = new OrderRequest();

		// cliente que realiza la aprobación de la compra.
		Payer payer = new Payer();

		this.orderRequest.checkoutPaymentIntent("CAPTURE");

		// Se configura la landing page, el nombre de la empresa que vende el producto y
		// la dirección de envio
		ApplicationContext applicationContext = new ApplicationContext().brandName("Ejemplo INC").landingPage("BILLING")
				.shippingPreference("SET_PROVIDED_ADDRESS");
		
		this.orderRequest.applicationContext(applicationContext);

		// Se obtienen los datos personales del comprador
		String nombre = sessionBean.getPersona().getNombre();
		String primerApellido = sessionBean.getPersona().getPrimerApellido();
		String segundoApellido = sessionBean.getPersona().getSegundoApellido();

		// Se crea la lista de unidades de compra a mostrarse en el formulario de PayPal
		List<PurchaseUnitRequest> purchaseUnitRequests = new ArrayList<PurchaseUnitRequest>();

		List<Item> items = new ArrayList<Item>();

		// Se obtienen los productos seleccionados en el carrito de la persona o usuario
		// en sesión.
		List<CarritoAlbum> carritoAlbums = sessionBean.getPersona().getCarrito().getCarritosAlbum();

		// Se definen las variables que indicaran los impuestos de la compra.
		double impuestoPorProducto = 10.00;
		double impuestoSumaTotalProductos = 0.0;

		// Se obtiene e iteran cada producto del carrito y se agregan al objeto item al
		// objeto de PayPal para mostrarse en el detalle de compra de PayPal
		for (CarritoAlbum carritoAlbum : carritoAlbums) {
			Item item = new Item();
			item.name(carritoAlbum.getAlbum().getNombre());

			String descripcionCorta = carritoAlbum.getAlbum().getDescripcion().substring(0, 50);

			item.description(descripcionCorta);

			item.unitAmount(new Money().currencyCode("MXN").value(String.valueOf(carritoAlbum.getAlbum().getValor())));
			item.tax(new Money().currencyCode("MXN").value(String.valueOf(impuestoPorProducto)));
			item.quantity(String.valueOf(carritoAlbum.getCantidad()));
			item.category("PHYSICAL_GOODS");
			item.sku("SKU1");

			items.add(item);

			impuestoSumaTotalProductos += impuestoPorProducto * carritoAlbum.getCantidad();
		}

		// Se configura el detalle de envio de los productos
		ShippingDetail shippingDetail = new ShippingDetail();
		shippingDetail.name(new Name().fullName(nombre + " " + primerApellido + " " + segundoApellido));
		shippingDetail
			.addressPortable(new AddressPortable().addressLine1("CALLE ANONIMA")
			.addressLine2("COLONIA DESCONOCIDA")
			.adminArea1("MEXICO")
			.adminArea2("MORELOS")
			.postalCode("00000")
			.countryCode("MX"));

		// Se aplica un formato a la cantidad del total de compra de los productos.
		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		double totalConDecimales = Double.valueOf(decimalFormat.format(sessionBean.getTotalCompra()));

		double envio = 50.00;
		double handling = 10.0;
		double descuentoEnvio = 20.00;

		double totalCompraConImpuestos = totalConDecimales + impuestoSumaTotalProductos + handling
				+ (envio - descuentoEnvio);

		// Se agrega la información calculada con los items en la unidad de compra.
		PurchaseUnitRequest purchaseUnitRequest = new PurchaseUnitRequest();
		purchaseUnitRequest.items(items);
		purchaseUnitRequest.shippingDetail(shippingDetail);
		purchaseUnitRequest.amountWithBreakdown(new AmountWithBreakdown()
			.currencyCode("MXN").value(String.valueOf(totalCompraConImpuestos))
			.amountBreakdown(new AmountBreakdown()
			.itemTotal(new Money().currencyCode("MXN").value(String.valueOf(totalConDecimales)))
			.shipping(new Money().currencyCode("MXN").value(String.valueOf(envio)))
			.handling(new Money().currencyCode("MXN").value(String.valueOf(handling)))
			.taxTotal(new Money().currencyCode("MXN").value(String.valueOf(impuestoSumaTotalProductos)))
			.shippingDiscount(new Money().currencyCode("MXN").value(String.valueOf(descuentoEnvio)))));
		
		// Se agrega la unidad de compra a la lista y a la orden final de compra.
		purchaseUnitRequests.add(purchaseUnitRequest);
		this.orderRequest.purchaseUnits(purchaseUnitRequests);
		
		payer.addressPortable(purchaseUnitRequest.shippingDetail().addressPortable());
		this.orderRequest.payer(payer);
		Gson gson = new Gson();
		
		LOGGER.info(gson.toJson(purchaseUnitRequests));

		return orderRequest;
	}
}
