package com.StartIot.StartIot.service;

import com.StartIot.StartIot.model.Usuario;

import java.util.List;

public interface IusuariosService {
    List<Usuario> obtenerTodosLosUsuarios();
    void guardarUsuario(Usuario usuario);
    void eliminarUsuario(Long id);
    Usuario editarUsuario(Long id, Usuario usuarioActualizado);
    Usuario encontrarUsuarioPorId(Long id);



}
