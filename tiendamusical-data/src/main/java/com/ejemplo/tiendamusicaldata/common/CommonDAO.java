/**
 * 
 */
package com.ejemplo.tiendamusicaldata.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author paco_
 * Clase genérica que representa los métodos del CRUD que se reutiliza en todas las entidades del proyecto.
 * E - Significa la Entidad a utilizar en el CRUD.
 * R - Significa el Repositorio a utilizar de JPA para ejecutar el CRUD
 */
public class CommonDAO<E, R extends PagingAndSortingRepository<E, Long>> {
	
	@Autowired
	protected R repository;
	
	/**
	 * Método que permite consultar una lista de datos paginable desde una entidad.
	 * @param desde {@link Integer} Indica a partir de que valor se obtedrán los resultados
	 * @param hasta {@link Integer} Indica el límite de resultados paginados a obtener
	 * @param orderBy {@link String} Indica a partir de que campo se ordenarán los resultados
	 * @return {@link List} Lista con los datos consultados paginados.
	 */
	public List<E> consultarListaPaginable(int desde, int hasta, String orderBy){
		Pageable pageable = PageRequest.of(desde, hasta, Sort.by(orderBy));
		Page<E> page = this.repository.findAll(pageable);
		return page.getContent();
	}
	
	/**
	 * Metodo que permite persistir la información de cualquier entidad.
	 * @param e {@link Object} Objeto o entidad a persistir.
	 * @return {@link Object} Objeto recuperado después de persistir el registro
	 */
	public E guardar(E e) {
		return this.repository.save(e);
	}
	
	/**
	 * Metodo que permite actualizar la información de cualquier entidad.
	 * @param e {@link Object} Objeto o entidad a actualizar.
	 * @return {@link Object} Objeto recuperado después de actualizar el registro
	 */
	public E actualizar(E e) {
		return this.repository.save(e);
	}
	
	/**
	 * Metodo que permite eliminar la información de cualquier entidad.
	 * @param e {@link Object} Objeto o entidad a eliminar.
	 */
	public void eliminar(E e) {
		this.repository.delete(e);
	}
}
