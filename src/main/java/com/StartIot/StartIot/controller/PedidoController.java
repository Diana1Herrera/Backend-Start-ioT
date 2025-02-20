package com.StartIot.StartIot.controller;

import com.StartIot.StartIot.model.Pedido;
import com.StartIot.StartIot.service.IpedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class PedidoController {

    @Autowired
    private IpedidoService pedidoService;

    @GetMapping("pedidos/traer")
    public List<Pedido> obtenerPedido(){
        return pedidoService.obtenerTodopedidos();
    }

    @PostMapping("/pedidos/crear")
    public String crearPedido(@RequestBody Pedido pedido){
        pedidoService.guardarPedido(pedido);
        return "El pedido fue creado con exito";
    }

    @DeleteMapping("/pedidos/eliminar/{id}")
    public String eliminarPedido(@PathVariable Long id){

        pedidoService.eliminarPedido(id);
        return "El pedido se eliminó con exito";
    }

    @PutMapping("/pedidos/editar")
    public ResponseEntity<?> editarPedido(@PathVariable Long id, @RequestBody Pedido pedidoActualizado) {
        try {
            Pedido pedidoEditado = pedidoService.editarPedido(id, pedidoActualizado);
            return ResponseEntity.ok(pedidoEditado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el pedido.");
        }
    }


}
