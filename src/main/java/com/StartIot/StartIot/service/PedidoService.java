package com.StartIot.StartIot.service;

import com.StartIot.StartIot.model.Pedido;

import java.util.List;

public class PedidoService implements IpedidoService{
    @Override
    public List<Pedido> obtenerTodopedidos() {
        return List.of();
    }

    @Override
    public void guardarPedido(Pedido pedido) {

    }

    @Override
    public void eliminarPedido(Long id) {

    }

    @Override
    public void editarPedido(Long id, Pedido pedidoActualizado) {

    }

    @Override
    public Pedido encontrarPedidoPorId(Long id) {
        return null;
    }

    @Override
    public void crearPedido(Pedido pedido) {

    }
}
