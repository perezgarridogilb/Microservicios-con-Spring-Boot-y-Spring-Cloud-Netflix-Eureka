package com.formacionbdi.springboot.app.item.springbootservicioitem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.formacionbdi.springboot.app.item.springbootservicioitem.models.Item;
import com.formacionbdi.springboot.app.item.springbootservicioitem.models.service.ItemService;

@RestController
public class ItemController {

    /**
     * Creando métodos handler
     */

    @Autowired
    @Qualifier("serviceFeign")
    private ItemService itemService;

    @GetMapping("/listar")
    public List<Item> listar() {
        return itemService.findAll();
    }

    @GetMapping("/ver/{id}/cantidad/{cantidad}")
    public Item detalle(@PathVariable Long id, @PathVariable Integer cantidad) {
        return itemService.findById(id, cantidad);
    }
    
}
