/**
 * 
 */
package com.ejemplo.tiendamusicalservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.tiendamusicaldata.dao.ArtistaDAO;
import com.ejemplo.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.ejemplo.tiendamusicalentities.entities.Persona;
import com.ejemplo.tiendamusicalservices.service.HomeService;


/**
 * @author paco_
 * Clase que implementa los métodos de lógica de negocio de la interface de LoginService
 */
@Service
public class HomeServiceImpl implements HomeService {

	@Autowired
	private ArtistaDAO artistaDAOImpl;

	@Override
	public List<ArtistaAlbumDTO> consultarAlbumFiltro(String filtro) {
		return this.artistaDAOImpl.consultarArtistasAlbumsPorFiltro(filtro);
	}

}
