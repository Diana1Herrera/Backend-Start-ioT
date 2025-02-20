package com.StartIot.StartIot.service;

import com.StartIot.StartIot.model.Pedido;
import com.StartIot.StartIot.repository.IpedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PedidoService implements IpedidoService{

    @Autowired
    private IpedidoRepository pedidoRepository; // Referencia


    @Override
    public List<Pedido> obtenerTodopedidos() {
        List<Pedido> listapedidos = pedidoRepository.findAll();
        return listapedidos;
    }

    @Override
    //Guardar o crear
    public void guardarPedido(Pedido pedido) {
        pedidoRepository.save(pedido);

    }

    @Override
    public void eliminarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
    @Override
    public Pedido encontrarPedidoPorId(Long id) {
        Pedido pedidoEncontrado = pedidoRepository.findById(id).orElse(null);
        return pedidoEncontrado;
    }
    private void validarPedido(Pedido pedido) {
        if (pedido.getCantidad() <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser mayor que cero.");
        }
        if (pedido.getTotal() == null || pedido.getTotal() < 0) {
            throw new IllegalArgumentException("El total no puede ser nulo ni negativo.");
        }
    }

    @Override
    public Pedido editarPedido(Long id, Pedido pedidoActualizado) {
        try {
            if (pedidoActualizado == null) {
                throw new IllegalArgumentException("El pedido actualizado no puede ser nulo.");
            }

            // Buscar el pedido con Optional para evitar valores nulos
            return pedidoRepository.findById(id).map(pedidoExistente -> {
                validarPedido(pedidoActualizado);  // Llamada a la validación

                pedidoExistente.setCantidad(pedidoActualizado.getCantidad());
                pedidoExistente.setTotal(pedidoActualizado.getTotal());

                return pedidoRepository.save(pedidoExistente);  // Guardar cambios
            }).orElseThrow(() -> new IllegalArgumentException("No se encontró el pedido con ID: " + id));

        }  catch (Exception e) {
            System.out.println("Ocurrió un error al actualizar el pedido: " + e.getMessage());
            throw new RuntimeException("Error inesperado al actualizar el pedido", e);
        }
    }





}
