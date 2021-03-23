/**
 * 
 */
package com.ejemplo.tiendamusicaldata.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ejemplo.tiendamusicalentities.entities.Persona;

/**
 * @author paco_
 * Clase DAO que realiza el CRUD con Spring JPA para la tabla persona.
 */
public interface PersonaDAO extends PagingAndSortingRepository<Persona, Long>{
	
	/**
	 * Método que permite consultar el usuario que trata de ingresar la sesión
	 * @param usuario {@link String} Usuario capturado por la persona
	 * @param password {@link String} Contraseña capturada por la persona
	 * @return {@link Persona} Objeto con la persona encontrada
	 */
	@Query("SELECT p from Persona p WHERE p.usuario = ?1 AND p.password = ?2")
	Persona findByUsuarioAndPassword(String usuario, String password);
	
}
