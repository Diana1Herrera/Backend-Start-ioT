package com.StartIot.StartIot.repository;

import com.StartIot.StartIot.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IusuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByCorreo(String correo); // Buscar por correo
}
