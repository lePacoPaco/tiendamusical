/**
 * 
 */
package com.ejemplo.tiendamusicalweb.session;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ejemplo.tiendamusicalentities.entities.Persona;

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

}
