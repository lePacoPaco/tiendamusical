/**
 * 
 */
package com.ejemplo.tiendamusicaldata.dao.impl;

import com.ejemplo.tiendamusicaldata.common.CommonDAO;
import com.ejemplo.tiendamusicaldata.dao.PersonaDAO;
import com.ejemplo.tiendamusicalentities.entities.Persona;

/**
 * @author paco_
 * Clase que implementa el CRUD genérico y las funciones de la interfaz de PersonaDAO
 */
public class PersonaDAOImpl extends CommonDAO<Persona, PersonaDAO> {
	
	/**
	 * Método que permite consultar una persona por su usuario y contraseña
	 * @param usuario {@link String} usuario capturado por la persona
	 * @param password {@link String} contraseña capturado por la persona
	 * @return {@link Persona} persona encontrada
	 */
	public Persona findUsuarioAndPassword(String usuario, String password) {
		return this.repository.findByUsuarioAndPassword(usuario, password);
	}

}
