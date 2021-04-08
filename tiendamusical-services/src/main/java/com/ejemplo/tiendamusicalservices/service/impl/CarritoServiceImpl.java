/**
 * 
 */
package com.ejemplo.tiendamusicalservices.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ejemplo.tiendamusicaldata.dao.CarritoAlbumDAO;
import com.ejemplo.tiendamusicalentities.dto.ArtistaAlbumDTO;
import com.ejemplo.tiendamusicalentities.entities.Carrito;
import com.ejemplo.tiendamusicalentities.entities.CarritoAlbum;
import com.ejemplo.tiendamusicalservices.service.CarritoService;

/**
 * @author paco_ Clase que implementa los métodos de la lógica de negocio de
 *         carrito service para el carrito de compras.
 */
@Service
public class CarritoServiceImpl implements CarritoService {

	@Autowired
	private CarritoAlbumDAO carritoAlbumDAO;

	@Override
	public CarritoAlbum guardarAlbumsCarrito(ArtistaAlbumDTO artistaAlbumDTO, Carrito carrito,
			int cantidadAlbumSeleccionada) {
		CarritoAlbum carritoAlbum = new CarritoAlbum();
		carritoAlbum.setAlbum(artistaAlbumDTO.getAlbum());
		carritoAlbum.setCarrito(carrito);
		carritoAlbum.setCantidad(cantidadAlbumSeleccionada);
		carritoAlbum.setEstatus("PENDIENTE");

		this.carritoAlbumDAO.save(carritoAlbum);

		return carritoAlbum;
	}

	@Override
	public float calcularTotal(Carrito carrito) {
		float total = 0.0F;

		// Se realiza el cálculo del total de la compra
		for (CarritoAlbum carritoAlbum : carrito.getCarritosAlbum()) {
			total += (carritoAlbum.getAlbum().getValor() * carritoAlbum.getCantidad());
		}
		return total;
	}

	@Override
	public void eliminarAlbumCarrito(CarritoAlbum carritoAlbum) {
		this.carritoAlbumDAO.delete(carritoAlbum);

	}

	@Override
	public float actualizarAlbumCantidad(CarritoAlbum carritoAlbum, Carrito carrito) {
		this.carritoAlbumDAO.save(carritoAlbum);
		
		return this.calcularTotal(carrito);
		
	}

}
