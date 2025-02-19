package com.StartIot.StartIot.service;

import com.StartIot.StartIot.model.Pedido;
import com.StartIot.StartIot.model.Producto;
import com.StartIot.StartIot.repository.IpedidoRepository;
import com.StartIot.StartIot.repository.IproductoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ProductoService implements IproductoService {
    @Autowired
    private IproductoRepository productoRepository;



    @Override
    public List<Producto> obtenerTodoProductos() {
        List<Producto> listaProductos = productoRepository.findAll();
        return listaProductos;
    }

    @Override
    // GUARDAR O CREAR PRODUCTOS
    public void guardarProducto (Producto producto){
        productoRepository.save(producto);
    }

    @Override
    public void eliminarProducto (Long id){ productoRepository.deleteById(id);}

    @Override
    public Producto encontrarProductoPorId(Long id){
        Producto productoEncontrado = productoRepository.findById(id).orElse(null);
        return productoEncontrado;
    }



}
