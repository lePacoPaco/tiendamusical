/**
 * 
 */
package com.ejemplo.tiendamusicalweb.controllers;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ejemplo.tiendamusicalentities.entities.CarritoAlbum;
import com.ejemplo.tiendamusicalservices.service.CarritoService;
import com.ejemplo.tiendamusicalweb.session.SessionBean;

/**
 * @author paco_ Clase que se encarga de controlar el flujo de la pantalla del
 *         carrito de compras.
 */
@ManagedBean
@ViewScoped
public class CarritoController {
	
	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o
	 * en el archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(CarritoController.class);

	/**
	 * Objeto que contiene la información en sesión del usuario.
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;	

	/**
	 * Objeto que realiza la lógica de negocio para el carrito de compras.
	 */
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;
	
	/**
	 * Inicializa la información de la pantalla del carrito.
	 */
	@PostConstruct
	public void init() {
		this.calcularTotal();
	}
	
	/**
	 * Método que permite calcular el total de la compra con respecto a los album en el carrito.
	 */
	public void calcularTotal() {
		float total = this.carritoServiceImpl.calcularTotal(this.sessionBean.getPersona().getCarrito());
		this.sessionBean.setTotalCompra(total);
	}

	/**
	 * Metodo que permite eliminar un album del carrito del usuario
	 * @param carritoAlbum {@link CarritoAlbum} objeto con el album a eliminar del carrito
	 */
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
		LOGGER.info("Eliminando album "+carritoAlbum.getAlbum().getNombre()+" del carrito");
		this.carritoServiceImpl.eliminarAlbumCarrito(carritoAlbum);
		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().remove(carritoAlbum);
		
		this.calcularTotal();
	}
	
	/**
	 * Método que permite actualizar la cantidad y los totales del album a comprar.
	 * @param carritoAlbum {@link CarritoAlbum} objeto que contiene el album a actualizar y su cantidad.
	 */
	public void actualizarCantidadCarrito(CarritoAlbum carritoAlbum) {
		float totalCompra = this.carritoServiceImpl.actualizarAlbumCantidad(carritoAlbum, this.sessionBean.getPersona().getCarrito());
		
		this.sessionBean.setTotalCompra(totalCompra);
	}
	
	/**
	 * @return the carritoServiceImpl
	 */
	public CarritoService getCarritoServiceImpl() {
		return carritoServiceImpl;
	}

	/**
	 * @param carritoServiceImpl the carritoServiceImpl to set
	 */
	public void setCarritoServiceImpl(CarritoService carritoServiceImpl) {
		this.carritoServiceImpl = carritoServiceImpl;
	}

	/**
	 * @return the sessionBean
	 */
	public SessionBean getSessionBean() {
		return sessionBean;
	}

	/**
	 * @param sessionBean the sessionBean to set
	 */
	public void setSessionBean(SessionBean sessionBean) {
		this.sessionBean = sessionBean;
	}
}
