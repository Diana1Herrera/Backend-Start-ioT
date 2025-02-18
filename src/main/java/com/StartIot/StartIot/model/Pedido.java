package com.StartIot.StartIot.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //id sequencial
    private Long id_pedido;
    private Double total;
    private int cantidad;


    public Pedido(Long id_pedido, Double total, int cantidad) {
        this.id_pedido = id_pedido;
        this.total = total;
        this.cantidad = cantidad;
    }

    public Pedido() {
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
}
