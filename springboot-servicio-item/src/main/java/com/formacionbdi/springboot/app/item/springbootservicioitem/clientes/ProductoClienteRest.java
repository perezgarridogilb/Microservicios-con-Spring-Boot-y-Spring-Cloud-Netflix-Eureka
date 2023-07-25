package com.formacionbdi.springboot.app.item.springbootservicioitem.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.formacionbdi.springboot.app.item.springbootservicioitem.models.Producto;

/**
 * Se declara que es un cliente feign
 * 
 * Implementando el cliente rest
 */
@FeignClient(name = "servicio-productos", url = "localhost:8001")
public interface ProductoClienteRest {
    @GetMapping("/listar")
    public List<Producto> listar();

    @GetMapping("/ver/{id}")
    public Producto detalle(@PathVariable Long id);

}