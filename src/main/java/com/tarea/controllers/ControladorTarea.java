package com.tarea.controllers;

import com.tarea.entities.Tarea;
import com.tarea.services.ServicioTarea;

public class ControladorTarea {

    private Tarea tarea;
    private ServicioTarea serviciotarea;

    public ControladorTarea(){
        this.tarea = this.serviciotarea.getTarea();
    }
}
