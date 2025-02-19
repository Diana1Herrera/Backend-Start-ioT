package com.StartIot.StartIot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Activo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) // ID secuencial
    private Long idactivo;
    private String nombreActivo;
    private Long fkIdProducto; // Clave foránea


    public Activo(Long idactivo, String nombreActivo, Long fkIdProducto) {
        this.idactivo = idactivo;
        this.nombreActivo = nombreActivo;
        this.fkIdProducto = fkIdProducto;
    }


    public Activo() {
    }


    public Long getIdactivo() {return idactivo; }

    public void setIdactivo(Long idactivo) {this.idactivo = idactivo; }

    public String getNombreActivo() {return nombreActivo; }

    public void setNombreActivo(String nombreActivo) {this.nombreActivo = nombreActivo;}

    public Long getFkIdProducto() {return fkIdProducto; }

    public void setFkIdProducto(Long fkIdProducto) {this.fkIdProducto = fkIdProducto; }
}
