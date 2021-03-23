/**
 * 
 */
package com.ejemplo.tiendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.tiendamusicaldata.dao.PersonaDAO;
import com.ejemplo.tiendamusicalentities.entities.Persona;
import com.ejemplo.tiendamusicalservices.service.LoginService;

/**
 * @author paco_
 * Clase que implementa las funciones para la lógica de negocio para la pantalla de login
 */
@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private PersonaDAO personaDAOImpl;
	
	@Override
	public Persona consultarUsuarioLogin(String usuario, String password) {
		return this.personaDAOImpl.findByUsuarioAndPassword(usuario, password);
	}

}
