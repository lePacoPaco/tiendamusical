/**
 * 
 */
package com.ejemplo.tiendamusicalentities.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author paco_
 * Clase que representa entidades de carritos de compras de una persona o usuario.
 */
@Entity
@Table(name = "carrito")
public class Carrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCarrito")
	private Long idCarrito;
	
	@OneToOne
	@JoinColumn(name = "idPersona")
	private Persona persona;
	
	@OneToMany(mappedBy = "carrito", fetch = FetchType.EAGER)
	private List<CarritoAlbum> carritosAlbum;

	/**
	 * @return the idCarrito
	 */
	public Long getIdCarrito() {
		return idCarrito;
	}

	/**
	 * @param idCarrito the idCarrito to set
	 */
	public void setIdCarrito(Long idCarrito) {
		this.idCarrito = idCarrito;
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

	/**
	 * @return the carritosAlbum
	 */
	public List<CarritoAlbum> getCarritosAlbum() {
		return carritosAlbum;
	}

	/**
	 * @param carritosAlbum the carritosAlbum to set
	 */
	public void setCarritosAlbum(List<CarritoAlbum> carritosAlbum) {
		this.carritosAlbum = carritosAlbum;
	}
}
