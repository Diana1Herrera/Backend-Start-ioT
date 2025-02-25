package com.StartIot.StartIot.service;

import com.StartIot.StartIot.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import com.StartIot.StartIot.repository.IusuarioRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuariosService implements IusuariosService{
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private IusuarioRepository usuarioRepository;

    @Override
    public List<Usuario> obtenerTodosLosUsuarios() {
        List<Usuario> listaUsuarios = usuarioRepository.findAll();
        return listaUsuarios;
    }

    @Override
    public void guardarUsuario(Usuario usuario) {

        usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario encontrarUsuarioPorId(Long id) {
        Usuario usuarioEncontrado = usuarioRepository.findById(id).orElse(null);
        return usuarioEncontrado;
    }

    private void validarUsuario(Usuario usuario) {
        if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (usuario.getCorreo() == null || !usuario.getCorreo().contains("@")) {
            throw new IllegalArgumentException("El correo electrónico no es válido.");
        }
    }

    @Override
    public Usuario editarUsuario(Long id, Usuario usuarioActualizado) {
        if (usuarioActualizado == null) {
            throw new IllegalArgumentException("El usuario actualizado no puede ser nulo.");
        }

        return usuarioRepository.findById(id).map(usuarioExistente -> {
            if (usuarioActualizado.getNombre() == null || usuarioActualizado.getNombre().isEmpty()) {
                throw new IllegalArgumentException("El nombre no puede estar vacío.");
            }

            usuarioExistente.setNombre(usuarioActualizado.getNombre());
            usuarioExistente.setApellido(usuarioActualizado.getApellido());
            usuarioExistente.setCorreo(usuarioActualizado.getCorreo());
            usuarioExistente.setTelefono(usuarioActualizado.getTelefono());
            usuarioExistente.setDireccion(usuarioActualizado.getDireccion());
            usuarioExistente.setContrasena(usuarioActualizado.getContrasena());

            return usuarioRepository.save(usuarioExistente);
        }).orElseThrow(() -> new IllegalArgumentException("No se encontró el usuario con ID: " + id));
    }




    public Usuario crearUsuario(Usuario usuario) {
       Usuario usuarioRegistrado = new Usuario();
       usuarioRegistrado.setCorreo(usuario.getCorreo());
       usuarioRegistrado.setNombre(usuario.getNombre());
       usuarioRegistrado.setTelefono(usuario.getTelefono());
       usuarioRegistrado.setApellido(usuario.getApellido());
       usuarioRegistrado.setDireccion(usuario.getDireccion());
       usuarioRegistrado.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
       //encripto la ccontraseña y la devuelve

        return usuarioRepository.save(usuarioRegistrado);
    }

    public UserDetails loadUserByUsername (String correo) throws UsernameNotFoundException{
        Usuario usuario = usuarioRepository.findByCorreo(correo);
        if (usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }
        return new  org.springframework.security.core.userdetails.User(usuario.getCorreo(), usuario.getContrasena(), new ArrayList<>());
    }


}
