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

import com.ejemplo.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.ejemplo.tiendamusicalentities.entities.CarritoAlbum;
import com.ejemplo.tiendamusicalservices.service.CarritoService;
import com.ejemplo.tiendamusicalweb.session.SessionBean;

/**
 * @author paco_ Clase que controla el flujo de la pantalla de Detalle.xhtml
 */
@ManagedBean
@ViewScoped
public class DetalleController {

	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o
	 * en el archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(DetalleController.class);

	/**
	 * Cantidad del producto o album seleccionado
	 */
	private int cantidadAlbumSeleccionada;

	/**
	 * Objeto que contiene los métodos de la lógica de negocio del carrito.
	 */
	@ManagedProperty("#{carritoServiceImpl}")
	private CarritoService carritoServiceImpl;

	/**
	 * Objeto que contiene la información del usuario en sesión
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;

	/**
	 * Inicializa la pantalla de detalle
	 */
	@PostConstruct
	public void init() {
		this.cantidadAlbumSeleccionada = 1;

	}

	/**
	 * Método que permite agregar el álbum seleccionado por el usuario al carrito de
	 * compras
	 * 
	 * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objeto con el album
	 *                        seleccionado
	 */
	public void agregarAlbumCarrito(ArtistaAlbumDTO artistaAlbumDTO) {
		LOGGER.info("Agregando Album al carrito de compras..." + artistaAlbumDTO.getArtista().getNombre());
		LOGGER.info("Cantidad del album" + this.cantidadAlbumSeleccionada);

		CarritoAlbum carritoAlbumAgregado = this.carritoServiceImpl.guardarAlbumsCarrito(artistaAlbumDTO,
				this.sessionBean.getPersona().getCarrito(), cantidadAlbumSeleccionada);

		this.sessionBean.getPersona().getCarrito().getCarritosAlbum().add(carritoAlbumAgregado);
	}

	/**
	 * @return the cantidadAlbumSeleccionada
	 */
	public int getCantidadAlbumSeleccionada() {
		return cantidadAlbumSeleccionada;
	}

	/**
	 * @param cantidadAlbumSeleccionada the cantidadAlbumSeleccionada to set
	 */
	public void setCantidadAlbumSeleccionada(int cantidadAlbumSeleccionada) {
		this.cantidadAlbumSeleccionada = cantidadAlbumSeleccionada;
	}

	/**
	 * @return the logger
	 */
	public static Logger getLogger() {
		return LOGGER;
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
