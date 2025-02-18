package com.StartIot.StartIot.service;
import com.StartIot.StartIot.model.Pedido;
import java.util.List;

public interface IpedidoService {


    List<Pedido> obtenerTodopedidos();
    void guardarPedido(Pedido pedido);
    void eliminarPedido(Long id);
    void editarPedido(Long id, Pedido pedidoActualizado);
    Pedido encontrarPedidoPorId (Long id);
    void crearPedido(Pedido pedido);










}
