/**
 * 
 */
package com.ejemplo.tiendamusicalweb.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ejemplo.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.ejemplo.tiendamusicalentities.entities.Persona;
import com.paypal.http.HttpResponse;
import com.paypal.orders.Order;

/**
 * @author paco_
 * Clase que mantendrá la información en la sesión del usuario.
 */
@ManagedBean
@SessionScoped
public class SessionBean {
	
	/**
	 * Objeto persona que se mantendrá en la sesión
	 */
	private Persona persona;
	
	/**
	 * Objeto que contendra la informacion del detalle del album seleccionado por el cliente
	 */
	private ArtistaAlbumDTO artistaAlbumDTO;
	
	/**
	 * Total generado de la compra en sesión.
	 */
	private float totalCompra;
	
	/**
	 * Orden generada por PayPal
	 */
	private HttpResponse<Order> order;
	
	/**
	 * Número del paso actual del proceso de compra
	 */
	private int paso;
	
	@PostConstruct
	public void init() {
		System.out.println("Creando Sesión...");
	}

	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}

	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	/**
	 * @return the artistaAlbumDTO
	 */
	public ArtistaAlbumDTO getArtistaAlbumDTO() {
		return artistaAlbumDTO;
	}

	/**
	 * @param artistaAlbumDTO the artistaAlbumDTO to set
	 */
	public void setArtistaAlbumDTO(ArtistaAlbumDTO artistaAlbumDTO) {
		this.artistaAlbumDTO = artistaAlbumDTO;
	}

	/**
	 * @return the totalCompra
	 */
	public float getTotalCompra() {
		return totalCompra;
	}

	/**
	 * @param totalCompra the totalCompra to set
	 */
	public void setTotalCompra(float totalCompra) {
		this.totalCompra = totalCompra;
	}

	/**
	 * @return the order
	 */
	public HttpResponse<Order> getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(HttpResponse<Order> order) {
		this.order = order;
	}

	/**
	 * @return the paso
	 */
	public int getPaso() {
		return paso;
	}

	/**
	 * @param paso the paso to set
	 */
	public void setPaso(int paso) {
		this.paso = paso;
	}


}
