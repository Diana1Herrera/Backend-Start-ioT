package com.StartIot.StartIot.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

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
    @Column(updatable = false)

    private Date fechaRegistro;

    @OneToMany(mappedBy = "usuarioPedido", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Pedido> pedidos;

    @OneToMany(mappedBy = "activoUsuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Activo> activos;

    public Usuario() {
    }

    public Usuario(Long id_Usuario, String nombre, String apellido, String contrasena, String correo, String telefono, String direccion, Date fechaRegistro, List<Pedido> pedidos, List<Activo> activos) {
        this.id_Usuario = id_Usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasena = contrasena;
        this.correo = correo;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaRegistro = fechaRegistro;
        this.pedidos = pedidos;
        this.activos = activos;

        if (pedidos != null){
            for (Pedido pedido : pedidos){
                pedido.setUsuarioPedido(this);
            }
        }

        if (activos != null){
            for (Activo activo : activos){
                activo.setActivoUsuario(this);
            }
        }
    }

    @PrePersist
    protected void onCreate() {
        fechaRegistro = new Date(); // Asigna la fecha actual antes de guardar en la BD
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

    public List<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(List<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public List<Activo> getActivos() {
        return activos;
    }

    public void setActivos(List<Activo> activos) {
        this.activos = activos;
    }
}
