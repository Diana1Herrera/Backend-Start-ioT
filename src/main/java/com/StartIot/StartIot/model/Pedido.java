package com.StartIot.StartIot.model;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //id sequencial
    private Long id_pedido;
    private Double total;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioPedido;

    @ManyToMany
    @JoinTable
            (name = "productosPedido",
                    joinColumns = @JoinColumn(name = "pedido_id"),inverseJoinColumns = @JoinColumn(name = "producto_id")
            )private List<Producto> productos;


    public Pedido(Long id_pedido, Double total, int cantidad, Usuario usuarioPedido, List<Producto> productos) {
        this.id_pedido = id_pedido;
        this.total = total;
        this.cantidad = cantidad;
        this.usuarioPedido = usuarioPedido;
        this.productos = productos;
    }

    public Pedido() {
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(Long id_pedido) {
        this.id_pedido = id_pedido;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Usuario getUsuarioPedido() {
        return usuarioPedido;
    }

    public void setUsuarioPedido(Usuario usuarioPedido) {
        this.usuarioPedido = usuarioPedido;
    }
}