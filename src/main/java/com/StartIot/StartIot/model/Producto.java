package com.StartIot.StartIot.model;


import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.security.saml2.Saml2RelyingPartyProperties;

import java.util.List;

@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_producto;
    private String nombre;
    private String descripcion;
    private String categoria;
    private Double precio;
    private String img;
    private String especificacines;
    private String Compatible;

    @ManyToMany(mappedBy = "productos")
            private List<Pedido> pedidos;

    @OneToMany(mappedBy = "activoProducto", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activo> activos;


    public Producto() {
    }

    public Producto(Long id_producto, String nombre, String descripcion, String categoria, Double precio, String img, String especificacines, String compatible, List<Pedido> pedidos, List<Activo> activos) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.precio = precio;
        this.img = img;
        this.especificacines = especificacines;
        Compatible = compatible;
        this.pedidos = pedidos;
        this.activos = activos;

        if (activos != null){
            for (Activo activo : activos){
                activo.setActivoProducto(this);
            }
        }

    }

    public Long getId_producto() {
        return id_producto;
    }

    public void setId_producto(Long id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEspecificacines() {
        return especificacines;
    }

    public void setEspecificacines(String especificacines) {
        this.especificacines = especificacines;
    }

    public String getCompatible() {
        return Compatible;
    }

    public void setCompatible(String compatible) {
        Compatible = compatible;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Activo> getActivos() {
        return activos;
    }

    public void setActivos(List<Activo> activos) {
        this.activos = activos;
    }
}
