package com.formacionbdi.springboot.app.item.springbootservicioitem.models;

import java.util.List;

public interface ItemService {
    public List<item> findAll();
    public Item findById(Long id, Integer cantidad);
}
