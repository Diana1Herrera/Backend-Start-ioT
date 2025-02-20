package com.StartIot.StartIot.service;

import com.StartIot.StartIot.model.Activo;
import com.StartIot.StartIot.repository.IactivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivoService implements  IActivoService{

    @Autowired
    private IactivoRepository activoRepository; // Referencia


    @Override
    public List<Activo> obtenerTodoactivos() {

        return List.of();
    }

    @Override
    public void guardarActivo(Activo activo) {

    }

    @Override
    public void eliminarActivo(Long id) {

    }

    @Override
    public Activo encontrarActivoPorId(Long id) {
        return null;
    }

    @Override
    public Activo editarActivo(Long id, Activo Actualizado) {
        return null;
    }
}
