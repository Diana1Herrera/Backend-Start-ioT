package com.StartIot.StartIot.service;

import com.StartIot.StartIot.model.Activo;
import com.StartIot.StartIot.model.Pedido;
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
        List<Activo> listaActivos = activoRepository.findAll();
        return listaActivos;
    }

    @Override
    public void guardarActivo(Activo activo) {
    activoRepository.save(activo);
    }

    @Override
    public void eliminarActivo(Long id) {
    activoRepository.deleteById(id);
    }

    @Override
    public Activo encontrarActivoPorId(Long id) {
        Activo activoEncontrado = activoRepository.findById(id).orElse(null);
        return activoEncontrado;
    }

    @Override
    public Activo editarActivo(Long id, Activo Actualizado) {
        try {
            if (Actualizado == null) {
                throw new IllegalArgumentException("El activo actualizado no puede ser nulo.");
            }

            // Buscar el pedido con Optional para evitar valores nulos
            return activoRepository.findById(id).map(activoExistente -> {
                validarActivo(Actualizado);  // Llamada a la validación

                activoExistente.setNombreActivo(Actualizado.getNombreActivo());
                activoExistente.setActivoProducto(Actualizado.getActivoProducto());
                activoExistente.setActivoUsuario(Actualizado.getActivoUsuario());
                activoExistente.setFkIdProducto(Actualizado.getFkIdProducto());


                return activoRepository.save(activoExistente);  // Guardar cambios
            }).orElseThrow(() -> new IllegalArgumentException("No se encontró el activocon ID: " + id));

        }  catch (Exception e) {
            System.out.println("Ocurrió un error al actualizar el activo: " + e.getMessage());
            throw new RuntimeException("Error inesperado al actualizar el activo", e);
        }
    }

    private void validarActivo(Activo actualizado) {
    }
}
