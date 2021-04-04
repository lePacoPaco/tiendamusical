/**
 * 
 */
package com.ejemplo.tiendamusicalservices.service;

import java.util.List;

import com.ejemplo.tiendamusicalentities.dto.ArtistaAlbumDTO;

/**
 * @author paco_ Interface que define los métodos de lógica de negocio para la
 *         pantalla del Home.
 */
public interface HomeService {

	/**
	 * Método que permite consultar los album con base al filtro que ingrese el
	 * cliente en el buscador de su home
	 * 
	 * @param filtro {@link String} texto ingresado por el cliente
	 * @return {@link List} Lista de Album que coinciden con el texto ingresado
	 */
	List<ArtistaAlbumDTO> consultarAlbumFiltro(String filtro);
}
