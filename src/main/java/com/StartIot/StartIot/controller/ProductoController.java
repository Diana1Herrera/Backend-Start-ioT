package com.StartIot.StartIot.controller;

import com.StartIot.StartIot.model.Pedido;
import com.StartIot.StartIot.model.Producto;
import com.StartIot.StartIot.service.IproductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin("*")
public class ProductoController {

    @Autowired
    private IproductoService productoService;

    @GetMapping("/traer")
    public ResponseEntity<List<Producto>> obtenerProductos() {
        List<Producto> productos = productoService.obtenerTodoProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/traer/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = productoService.encontrarProductoPorId(id);
        if (producto != null) {
            return ResponseEntity.ok(producto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<String> crearProducto(@RequestBody Producto producto) {
        productoService.guardarProducto(producto);
        return ResponseEntity.ok("El producto fue creado con éxito");
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<String> eliminarProducto(@PathVariable Long id) {
        Producto producto = productoService.encontrarProductoPorId(id);
        if (producto != null) {
            productoService.eliminarProducto(id);
            return ResponseEntity.ok("El producto ha sido eliminado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
