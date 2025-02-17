package com.tarea.services;

import com.tarea.entities.Tarea;
import com.tarea.repositories.RepositoryTarea;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ServicioTarea {

    private RepositoryTarea repositoryTarea;

    public ServicioTarea(RepositoryTarea repositoryTarea) {
        this.repositoryTarea = repositoryTarea;
    }

    public List<Tarea> getAllTareas() {
        return this.repositoryTarea.findAll();
    }

    public Tarea getTarea(Long id) {
        return this.repositoryTarea.findById(id).orElse(null);
    }

    public Tarea insertarTarea(Tarea tarea) {
        return this.repositoryTarea.save(tarea);
    }

    public boolean actualizarTarea(Long id, String nombre, String descripcion, LocalDate fecha, Boolean estado) {
        Tarea tarea = this.repositoryTarea.getReferenceById(id);
        tarea.setNombre(nombre);
        tarea.setDescripcion(descripcion);
        tarea.setFecha(fecha);
        tarea.setEstado(estado);
        this.repositoryTarea.save(tarea);
        return true;
    }
}
