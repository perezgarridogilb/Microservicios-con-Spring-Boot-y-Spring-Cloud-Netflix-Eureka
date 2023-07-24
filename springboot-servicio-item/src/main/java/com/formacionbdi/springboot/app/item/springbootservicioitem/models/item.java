package com.formacionbdi.springboot.app.item.springbootservicioitem.models;

/** Generar item a partir de producto */
public class item {
    private Producto producto;
    private Integer cantidad;

    public Item() {

    }

    public item(Producto producto, Integer cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }
    public Producto getProducto() {
        return producto;
    }
    public void setProducto(Producto producto) {
        this.producto = producto;
    }
    public Integer getCantidad() {
        return cantidad;
    }
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return producto.getPrecio() * cantidad.doubleValue();
    }
    
}