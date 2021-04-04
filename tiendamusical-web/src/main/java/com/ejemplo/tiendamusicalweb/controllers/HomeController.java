/**
 * 
 */
package com.ejemplo.tiendamusicalweb.controllers;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import com.ejemplo.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.ejemplo.tiendamusicalservices.service.HomeService;

/**
 * @author paco_
 * Clase que controla el flujo de información para la pantalla de home de cualquier tipo de usuario
 */
@ManagedBean
@ViewScoped
public class HomeController {
	
	/**
	 * Texto ingresado por el cliente en el buscador
	 */
	private String filtro;
	
	/**
	 * Lista obtenida a partir del filtro ingresado en el buscador.
	 */
	private List<ArtistaAlbumDTO> artistasAlbumDTO;
	
	/**
	 * Se inyecta el objeto de Spring con JSF para obtener los métodos de lógica de negocio del home
	 */
	@ManagedProperty("#{homeServiceImpl}")
	private HomeService homeServiceImpl;
	
	/**
	 * Inicializando pantalla.
	 */
	@PostConstruct
	public void init() {
		System.out.println("Inicializando Home...");
	}
	
	/**
	 * Método que permite obtener los álbum de los artistas encontrados en la base de datos con respecto al filtro ingresado por el cliente.
	 */
	public void consultarAlbumArtistasPorFiltro() {
		this.artistasAlbumDTO = this.homeServiceImpl.consultarAlbumFiltro(this.filtro);
		
		if(this.artistasAlbumDTO != null) {
			this.artistasAlbumDTO.forEach(artistaAlbumDTO -> {
				System.out.println("Artista: "+artistaAlbumDTO.getArtista().getNombre());
			});
		}
	}

	/**
	 * @return the filtro
	 */
	public String getFiltro() {
		return filtro;
	}

	/**
	 * @param filtro the filtro to set
	 */
	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	/**
	 * @return the artistaAlbumDTO
	 */
	public List<ArtistaAlbumDTO> getArtistasAlbumDTO() {
		return artistasAlbumDTO;
	}

	/**
	 * @param artistaAlbumDTO the artistaAlbumDTO to set
	 */
	public void setArtistasAlbumDTO(List<ArtistaAlbumDTO> artistasAlbumDTO) {
		this.artistasAlbumDTO = artistasAlbumDTO;
	}

	/**
	 * @return the homeServiceImpl
	 */
	public HomeService getHomeServiceImpl() {
		return homeServiceImpl;
	}

	/**
	 * @param homeServiceImpl the homeServiceImpl to set
	 */
	public void setHomeServiceImpl(HomeService homeServiceImpl) {
		this.homeServiceImpl = homeServiceImpl;
	}
}
