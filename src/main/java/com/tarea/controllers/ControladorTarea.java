package com.tarea.controllers;

import com.tarea.entities.Tarea;
import com.tarea.services.ServicioTarea;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ControladorTarea {

    private ServicioTarea serviciotarea;

    public ControladorTarea(ServicioTarea serviciotarea){
        this.serviciotarea = serviciotarea;
    }

    @GetMapping("/tareas")
    public List<Tarea> tareas(){
        return this.serviciotarea.getAllTareas();
    }

}
