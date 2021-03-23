/**
 * 
 */
package com.ejemplo.tiendamusicalservices.service;

import com.ejemplo.tiendamusicalentities.entities.Persona;

/**
 * @author paco_
 * Interfaz que realiza la lógica de negocio para el inicio de sesión de la persona
 */
public interface LoginService {
	
	/**
	 * Método que permite consultar un usuario que trata de ingresar sesion en la tienda musical.
	 * @param usuario {@link String} usuario capturado por la persona
	 * @param password {@link String} contraseña capturada por la persona
	 * @return {@link Persona} usuario encontrado en la base de datos.
	 */
	Persona consultarUsuarioLogin(String usuario, String password);
}
