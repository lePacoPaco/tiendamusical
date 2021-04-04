/**
 * 
 */
package com.ejemplo.tiendamusicalentities.dto;

import com.ejemplo.tiendamusicalentities.entities.Album;
import com.ejemplo.tiendamusicalentities.entities.Artista;

/**
 * @author paco_ 
 * 	Clase DTO personalizada para obtener la informacion de los
 *         album que el cliente busca a traves del filtro de busqueda del
 *         dashboard
 */
public class ArtistaAlbumDTO {
	
	/**
	 * Objeto que contiene la información del artista
	 */
	private Artista artista;
	
	/**
	 * Objeto que contiene la información del album
	 */
	private Album album;
	
	/**
	 * Constructor default
	 */
	public ArtistaAlbumDTO() {
		super();
	}
	
	/**
	 * Constructor que inicializa la informacion consultada para la busqueda de Album.
	 * @param a {@link Album} Objeto que contiene el album del artista.
	 * @param ar {@link Artista} Objeto que contiene el artista (banda o solista).
	 */
	public ArtistaAlbumDTO(Album album, Artista artista) {
		this.album = album;
		this.artista = artista;
	}

	/**
	 * @return the artista
	 */
	public Artista getArtista() {
		return artista;
	}

	/**
	 * @param artista the artista to set
	 */
	public void setArtista(Artista artista) {
		this.artista = artista;
	}

	/**
	 * @return the album
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}
}
