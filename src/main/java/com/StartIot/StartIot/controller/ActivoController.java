package com.StartIot.StartIot.controller;

import com.StartIot.StartIot.model.Activo;
import com.StartIot.StartIot.service.IActivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activos")
public class ActivoController {

    @Autowired
    private IActivoService activoService;

    @GetMapping
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

    @PostMapping
    public ResponseEntity<String> guardarActivo(@RequestBody Activo activo) {
        activoService.guardarActivo(activo);
        return ResponseEntity.ok("Activo guardado exitosamente");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Activo> editarActivo(@PathVariable Long id, @RequestBody Activo actualizado) {
        Activo actualizadoActivo = activoService.editarActivo(id, actualizado);
        if (actualizadoActivo != null) {
            return ResponseEntity.ok(actualizadoActivo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarActivo(@PathVariable Long id) {
        activoService.eliminarActivo(id);
        return ResponseEntity.ok("Activo eliminado correctamente");
    }
}
