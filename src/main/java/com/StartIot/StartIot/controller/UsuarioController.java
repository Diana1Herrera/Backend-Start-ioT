package com.StartIot.StartIot.controller;


import com.StartIot.StartIot.JwtUtil;
import com.StartIot.StartIot.model.Usuario;
import com.StartIot.StartIot.service.IusuariosService;
import com.StartIot.StartIot.service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IusuariosService usuariosService;

    @Autowired
    private UsuariosService usuariosServicejwt;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Obtener todos los usuarios
    @GetMapping("/traer")
    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuariosService.obtenerTodosLosUsuarios();
    }

    // Crear un nuevo usuario
    @PostMapping("/crear")
    public ResponseEntity<String> crearUsuario(@RequestBody Usuario usuario) {
        usuariosServicejwt.guardarUsuario(usuario);
        return ResponseEntity.ok("El usuario fue creado con éxito.");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {
        UserDetails userDetails = usuariosServicejwt.loadUserByUsername(usuario.getCorreo());
        if (userDetails != null && passwordEncoder.matches(usuario.getContrasena(), userDetails.getPassword())) {
            String token = jwtUtil.generateToken(userDetails.getUsername());
            return ResponseEntity.ok(token);
        }
        return ResponseEntity.status(401).body("Credenciales inválidas");
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
