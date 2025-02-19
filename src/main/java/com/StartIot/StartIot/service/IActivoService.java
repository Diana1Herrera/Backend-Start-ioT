package com.StartIot.StartIot.service;
import com.StartIot.StartIot.model.Activo;
import java.util.List;

public interface IActivoService {


    List<Activo> obtenerTodoactivos();
    void guardarActivo(Activo activo); //Guardar o crear es =
    void eliminarActivo(Long id);
    Activo encontrarActivoPorId (Long id);
    Activo editarActivo(Long id, Activo Actualizado);
}
