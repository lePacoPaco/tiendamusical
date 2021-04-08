/**
 * 
 */
package com.ejemplo.tiendamusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ejemplo.tiendamusicalweb.utils.CommonUtils;

/**
 * @author paco_
 * Controlador que se encarga del flujo y acciones de la barra de navegación
 */
@ManagedBean
@ViewScoped
public class NavBarController {


	/**
	 * Objeto que permite mostrar los mensajes de LOG en la consola del servidor o
	 * en el archivo externo
	 */
	private static final Logger LOGGER = LogManager.getLogger(NavBarController.class);
	
	/**
	 * Incializando la pantalla carrito
	 */
	@PostConstruct
	public void init() {
		LOGGER.info("Inicializando pantalla carrito...");
	}
	
	/**
	 * Método que permite redireccionar a la pantalla de carrito de compras.
	 */
	public void redireccionar() {
		try {
			CommonUtils.redireccionar("/pages/cliente/carrito.xhtml");
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "Ups", "Error al redireccionar al carrito");
			e.printStackTrace();
		}
	}
}
