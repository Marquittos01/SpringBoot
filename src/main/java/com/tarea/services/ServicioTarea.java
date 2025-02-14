package com.tarea.services;

import com.tarea.entities.Tarea;
import com.tarea.repositories.RepositorioTarea;

import java.util.List;

public class ServicioTarea {
    private RepositorioTarea repositoryTarea;
    public ServicioTarea(RepositorioTarea repository) {
        this.repositoryTarea = repository;
    }
    public List<Tarea> getAllTareas(){
        return this.repositoryTarea.findAll();
    }
}
