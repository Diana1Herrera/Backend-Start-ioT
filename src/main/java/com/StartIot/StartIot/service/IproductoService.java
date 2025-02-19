package com.StartIot.StartIot.service;

import com.StartIot.StartIot.model.Pedido;
import com.StartIot.StartIot.model.Producto;

import java.util.List;

public interface IproductoService {

    List<Producto> obtenerTodoProductos();
    void guardarProducto(Producto producto);
    void eliminarProducto(Long id);
    Producto encontrarProductoPorId (Long id);

}
