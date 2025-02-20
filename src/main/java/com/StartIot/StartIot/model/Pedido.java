package com.StartIot.StartIot.model;


import jakarta.persistence.*;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) //id sequencial
    private Long id_pedido;
    private Double total;
    private int cantidad;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario pedidoUsuario;

    //Generar el constructor again


    public Pedido(Long id_pedido, Double total, int cantidad, Usuario pedidoUsuario) {
        this.id_pedido = id_pedido;
        this.total = total;
        this.cantidad = cantidad;
        this.pedidoUsuario = pedidoUsuario;
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

    public Usuario getPedidoUsuario() {
        return pedidoUsuario;
    }

    public void setPedidoUsuario(Usuario pedidoUsuario) {
        this.pedidoUsuario = pedidoUsuario;
    }
}
