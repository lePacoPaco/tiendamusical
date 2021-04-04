/**
 * 
 */
package com.ejemplo.tiendamusicalweb.controllers;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.ejemplo.tiendamusicalentities.entities.Persona;
import com.ejemplo.tiendamusicalservices.service.LoginService;
import com.ejemplo.tiendamusicalweb.session.SessionBean;
import com.ejemplo.tiendamusicalweb.utils.CommonUtils;

/**
 * @author paco_
 * Controlador que se encarga del flujo de la pantalla de login.xhtml
 */
@ManagedBean
@ViewScoped
public class LoginController {

	/**
	 * Usuario capturado por la persona.
	 */
	private String usuario;
	
	/**
	 * Contraseña capturada por la persona.
	 */
	private String password;
	
	/**
	 * Propiedad de la lógica de negocio inyectada con JSF y Spring
	 */
	@ManagedProperty("#{sessionBean}")
	private SessionBean sessionBean;
	
	/**
	 * Propiedad de la lógica de negocio inyectada con JSF y Spring
	 */
	@ManagedProperty("#{loginServiceImpl}")
	private LoginService loginServiceImpl; 
	
	@PostConstruct
	public void init() {
		System.out.println("Inicializando login...");
	}
	
	/**
	 * Metodo que permite a la persona ingresar a su pantalla de home.
	 */
	public void entrar() {
		Persona personaConsultada = this.loginServiceImpl.consultarUsuarioLogin(usuario, password);
		
		if (personaConsultada != null) {
			try {
				this.sessionBean.setPersona(personaConsultada);
				CommonUtils.redireccionar("/pages/commons/dashboard.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_FATAL, "¡Error!", "Formato incorrecto para ingresar a la pantalla deseada.");
			}
		} else {
			CommonUtils.mostrarMensaje(FacesMessage.SEVERITY_ERROR, "¡Ups!", "Usuario y/o contraseña incorrectos.");
		}
		
	}

	/**
	 * @return the usuario
	 */
	public String getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the loginServiceImpl
	 */
	public LoginService getLoginServiceImpl() {
		return loginServiceImpl;
	}

	/**
	 * @param loginServiceImpl the loginServiceImpl to set
	 */
	public void setLoginServiceImpl(LoginService loginServiceImpl) {
		this.loginServiceImpl = loginServiceImpl;
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
