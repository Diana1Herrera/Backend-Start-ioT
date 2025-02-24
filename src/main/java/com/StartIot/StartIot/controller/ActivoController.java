package com.StartIot.StartIot.controller;

import com.StartIot.StartIot.model.Activo;
import com.StartIot.StartIot.service.IActivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activos")
public class ActivoController {

    @Autowired
    private IActivoService activoService;

    @GetMapping("/traer")
    public ResponseEntity<List<Activo>> obtenerTodosLosActivos() {
        List<Activo> activos = activoService.obtenerTodoactivos();
        return ResponseEntity.ok(activos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Activo> obtenerActivoPorId(@PathVariable Long id) {
        Activo activo = activoService.encontrarActivoPorId(id);
        if (activo != null) {
            return ResponseEntity.ok(activo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/crear")
    public String crearActivo(@RequestBody Activo activo){
        activoService.guardarActivo(activo);
        return "El pedido fue creado con exito";
    }


    @DeleteMapping("/eliminar/{id}")
    public String eliminarActivo(@PathVariable Long id){

        activoService.eliminarActivo(id);
        return "El activo se eliminó con exito";
    }
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarActivo(@PathVariable Long id, @RequestBody Activo Actualizado) {
        try {
            Activo activoEditado = activoService.editarActivo(id, Actualizado);
            return ResponseEntity.ok(activoEditado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el activo.");
        }
    }
}
