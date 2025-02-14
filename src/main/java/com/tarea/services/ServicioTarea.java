package com.tarea.services;

import com.tarea.entities.Tarea;
import com.tarea.repositories.RepositoryTarea;

import java.util.List;

public class ServicioTarea {

    private RepositoryTarea repository;
    Tarea tarea;

    public ServicioTarea(RepositoryTarea repository) {
        this.repository = repository;
    }

    public List<Tarea> getAllTareas() {
        return this.repository.findAll();
    }

    public Tarea getTarea() {
        return tarea;
    }
}
