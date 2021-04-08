/**
 * 
 */
package com.ejemplo.tiendamusicaldata.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.ejemplo.tiendamusicalentities.entities.CarritoAlbum;

/**
 * @author paco_
 * Interface que implementa los métodos genéricos para el CRUD con SPRING JPA hacia la tabla de carrito album
 */
public interface CarritoAlbumDAO extends PagingAndSortingRepository<CarritoAlbum, Long> {

}
