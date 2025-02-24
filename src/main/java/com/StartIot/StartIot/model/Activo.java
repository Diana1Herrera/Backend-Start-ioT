package com.StartIot.StartIot.model;

import jakarta.persistence.*;

@Entity
public class Activo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // ID secuencial
    private Long idactivo;
    private String nombreActivo;
    private Long fkIdProducto; // Clave foránea

    @ManyToOne
    @JoinColumn(name = "activo_id")
    private Usuario activoUsuario;


    @ManyToOne
    @JoinColumn(name = "activoProducto_ID")
    private Producto activoProducto;

    public Activo() {
    }

    public Activo(Long idactivo, String nombreActivo, Long fkIdProducto, Usuario activoUsuario, Producto activoProducto) {
        this.idactivo = idactivo;
        this.nombreActivo = nombreActivo;
        this.fkIdProducto = fkIdProducto;
        this.activoUsuario = activoUsuario;
        this.activoProducto = activoProducto;
    }

    public Long getIdactivo() {
        return idactivo;
    }

    public void setIdactivo(Long idactivo) {
        this.idactivo = idactivo;
    }

    public Producto getActivoProducto() {
        return activoProducto;
    }

    public void setActivoProducto(Producto activoProducto) {
        this.activoProducto = activoProducto;
    }

    public String getNombreActivo() {
        return nombreActivo;
    }

    public void setNombreActivo(String nombreActivo) {
        this.nombreActivo = nombreActivo;
    }

    public Long getFkIdProducto() {
        return fkIdProducto;
    }

    public void setFkIdProducto(Long fkIdProducto) {
        this.fkIdProducto = fkIdProducto;
    }

    public Usuario getActivoUsuario() {
        return activoUsuario;
    }

    public void setActivoUsuario(Usuario activoUsuario) {
        this.activoUsuario = activoUsuario;
    }
}
