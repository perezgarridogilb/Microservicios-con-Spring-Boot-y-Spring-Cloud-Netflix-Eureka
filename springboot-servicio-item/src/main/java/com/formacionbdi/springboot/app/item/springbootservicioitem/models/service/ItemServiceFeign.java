package com.formacionbdi.springboot.app.item.springbootservicioitem.models.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.formacionbdi.springboot.app.item.springbootservicioitem.clientes.ProductoClienteRest;
import com.formacionbdi.springboot.app.item.springbootservicioitem.models.Item;

@Service("serviceFeign")
/** Implementación por defecto que tiene que inyectar en el autowired cuando no se especifica el nombre del componente
 * Otra forma serían los cualificadores
 */
@Primary
public class ItemServiceFeign implements ItemService {

    @Autowired
    private ProductoClienteRest clienteFeign;

    @Override
    public List<Item> findAll() {
        return clienteFeign.listar().stream().map(p -> new Item(p,1)).collect(Collectors.toList());
    }

    @Override
    public Item findById(Long id, Integer cantidad) {
        return new Item(clienteFeign.detalle(id), cantidad);
    }
    
}
