/**
 * 
 */
package com.ejemplo.tiendamusicalservices.service;

import com.ejemplo.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.ejemplo.tiendamusicalentities.entities.Carrito;
import com.ejemplo.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author paco_
 * Interface que define los métodos de lógica de negocio para el carrito de compras
 */
public interface CarritoService {
	
	/**
	 * Método que permite guardar los álbums a comprar en el carrito de compras
	 * @param artistaAlbumDTO {@link ArtistaAlbumDTO} objeto con la información del álbum en el carrito.
	 * @param carrito {@link Carrito} objeto con información del carrito del usuario
	 * @param cantidadAlbumSeleccionada {@link Integer} cantidad seleccionada del album por el usuario
	 */
	CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito, int cantidadAlbumSeleccionada);
	
	/**
	 * Método que permite calcular el total de la compra
	 * @param carrito {@link Carrito} objeto con la información del carrito a calcular.
	 * @return {@link Float} total calculado.
	 */
	float calcularTotal(Carrito carrito);
	
	/**
	 * Método que permite eliminar un álbum del carrito.
	 * @param carritoAlbum {@link CarritoAlbum} objeto con el álbum del carrito a eliminar
	 */
	void eliminarAlbumCarrito(CarritoAlbum carritoAlbum);
	
	/**
	 * Método que permite actualizar la cantidad del álbum a comprar en el carrito.
	 * @param carritoAlbum {@link CarritoAlbum} objeto con el álbum a actualizar en el carrito.
	 * @param carrito {@link Carrito} objeto con el carrito de compras del usuario.
	 * 
	 */
	float actualizarAlbumCantidad(CarritoAlbum carritoAlbum, Carrito carrito);
}
