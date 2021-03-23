/**
 * 
 */
package com.ejemplo.tiendamusicalweb.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * @author paco_
 * Clase generada para crear funciones globales o comunes entre clases del proyecto.
 *
 */
public class CommonUtils {
	/**
	 * Metodo que permite mostrar un mensaje al usuario.
	 * @param severity {@link Severity} objeto que indica el tipo de mensaje a mostrar
	 * @param summary {@link String} título del mensaje
	 * @param detail {@lin String} detalle del mensaje
	 */
	public static void mostrarMensaje(Severity severity, String summary, String detail) {
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity,summary,detail));
	}
}
