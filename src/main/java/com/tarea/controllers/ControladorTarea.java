package com.tarea.controllers;

import com.tarea.entities.Tarea;
import com.tarea.services.ServicioTarea;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class ControladorTarea {

    private Tarea tarea;
    private ServicioTarea serviciotarea;

    public ControladorTarea(){
        this.tarea = this.serviciotarea.getTarea();
    }

    @GetMapping("/tareas")
    public List<Tarea> getAllTareas(){
        return this.serviciotarea.getAllTareas();
    }


}
