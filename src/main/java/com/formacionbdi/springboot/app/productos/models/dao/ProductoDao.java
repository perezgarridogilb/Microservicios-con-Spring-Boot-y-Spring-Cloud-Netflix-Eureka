package com.formacionbdi.springboot.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.formacionbdi.springboot.app.productos.models.entity.Producto;

/**
 * Creando producto a través de la clase Entity repository
 */
public interface ProductoDao extends CrudRepository<Producto, Long> {
    
}
