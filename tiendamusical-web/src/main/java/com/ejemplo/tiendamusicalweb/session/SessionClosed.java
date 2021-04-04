/**
 * 
 */
package com.ejemplo.tiendamusicalweb.session;

import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.ejemplo.tiendamusicalweb.utils.CommonUtils;

/**
 * @author paco_
 * Clase que permite cerrar la sesión del usuario y redireccionar a la pantalla del login
 */
@ManagedBean
@ViewScoped
public class SessionClosed {

	/**
	 * Método que permite cerrar la sesión del usuario
	 */
	public void cerrarSesion() {
		try {
			FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
			CommonUtils.redireccionar("/login.xhtml");
		} catch (IOException e) {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "¡Ups!", "Problema al tratar de regresar al login. Favor de intentar más tarde.");
			e.printStackTrace();
		}
	}
}
