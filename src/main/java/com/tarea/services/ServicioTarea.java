package com.tarea.services;

import com.tarea.entities.Tarea;
import com.tarea.repositories.RepositoryTarea;

import java.util.List;

public class ServicioTarea {

    private RepositoryTarea repositoryTarea;
    Tarea tarea;

    public ServicioTarea(RepositoryTarea repositoryTarea) {
        this.repositoryTarea = repositoryTarea;
    }

    public List<Tarea> getAllTareas() {
        return this.repositoryTarea.findAll();
    }

    public Tarea getTarea() {
        return tarea;
    }
}
