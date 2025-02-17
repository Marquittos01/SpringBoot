package com.tarea.services;

import com.tarea.entities.Tarea;
import com.tarea.repositories.RepositoryTarea;
import org.springframework.stereotype.Service;

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
        return this.repositoryTarea.findById(id).get();
    }
}
