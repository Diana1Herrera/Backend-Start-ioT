package com.StartIot.StartIot.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_Usuario;
    private String nombre;
    private String apellido;
    private String contrasena;
    private String correo;
    private String telefono;
    private String direccion;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;

    public Usuario() {}

    public Usuario(String nombre, String apellido, String contrasena, String correo, String telefono, String direccion, Date fechaRegistro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId_Usuario() {
        return id_Usuario;
    }

    public void setId_Usuario(Long id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}
