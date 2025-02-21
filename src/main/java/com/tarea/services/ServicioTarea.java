package com.tarea.services;

import com.tarea.entities.Tarea;
import com.tarea.repositories.RepositoryTarea;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Tarea createTarea(Tarea tarea) {
        return this.repositoryTarea.save(tarea);
    }

    public Tarea updateTarea(Long id, Tarea tareaDetalles) {
        Optional<Tarea> tareaOptional = this.repositoryTarea.findById(id);

        if (tareaOptional.isPresent()) {
            Tarea tarea = tareaOptional.get();
            tarea.setNombre(tareaDetalles.getNombre());
            tarea.setDescripcion(tareaDetalles.getDescripcion());
            tarea.setEstado(tareaDetalles.getEstado());
            tarea.setFecha(tareaDetalles.getFecha());
            return this.repositoryTarea.save(tarea);
        } else {
            return null;
        }
    }

    public boolean deleteTarea(Long id) {
        if (this.repositoryTarea.existsById(id)) {
            this.repositoryTarea.deleteById(id);
            return true;
        }
        return false;
    }

}

