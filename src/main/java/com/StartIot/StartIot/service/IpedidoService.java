package com.StartIot.StartIot.service;
import com.StartIot.StartIot.model.Pedido;
import java.util.List;

public interface IpedidoService {


    List<Pedido> obtenerTodopedidos();
    void guardarPedido(Pedido pedido); //Guardar o crear es =
    void eliminarPedido(Long id);
    Pedido editarPedido(Long id, Pedido pedidoActualizado);
    Pedido encontrarPedidoPorId (Long id);











}
