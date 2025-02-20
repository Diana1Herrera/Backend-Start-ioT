package com.StartIot.StartIot.controller;


import com.StartIot.StartIot.model.Usuario;
import com.StartIot.StartIot.service.IusuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IusuariosService usuariosService;

    // Obtener todos los usuarios
    @GetMapping("/traer")
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuariosService.obtenerTodosLosUsuarios();
    }

    // Crear un nuevo usuario
    @PostMapping("/crear")
    public String crearUsuario(@RequestBody Usuario usuario) {
        usuariosService.guardarUsuario(usuario);
        return "El usuario fue creado con éxito.";
    }

    // Eliminar un usuario por ID
    @DeleteMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuariosService.eliminarUsuario(id);
        return "El usuario se eliminó con éxito.";
    }

    // Editar un usuario existente
    @PutMapping("/editar/{id}")
    public ResponseEntity<?> editarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        try {
            Usuario usuarioEditado = usuariosService.editarUsuario(id, usuarioActualizado);
            return ResponseEntity.ok(usuarioEditado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar el usuario.");
        }
    }

    // Obtener un usuario por ID
    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> encontrarUsuarioPorId(@PathVariable Long id) {
        try {
            Usuario usuario = usuariosService.encontrarUsuarioPorId(id);
            return ResponseEntity.ok(usuario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado.");
        }
    }


}
