/**
 * 
 */
package com.ejemplo.tiendamusicaldata.dao.impl;

import java.util.List;

import com.ejemplo.tiendamusicaldata.common.CommonDAO;
import com.ejemplo.tiendamusicaldata.dao.ArtistaDAO;
import com.ejemplo.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.ejemplo.tiendamusicalentities.entities.Artista;

/**
 * @author paco_
 * Clase que implementa el CRUD genérico para realizar las transacciones a la tabla de artista.
 */
public class ArtistaDAOImpl extends CommonDAO<Artista, ArtistaDAO> {
	
	public List<ArtistaAlbumDTO> consultarArtistaAlbumPorFiltro(String filtro){
		return this.repository.consultarArtistasAlbumsPorFiltro(filtro);
	}
}
