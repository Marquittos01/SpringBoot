package com.tarea.controllers;

import com.tarea.entities.Tarea;
import com.tarea.services.ServicioTarea;

public class ControladorTarea {
    Tarea tarea;
    ServicioTarea servicioTarea = new ServicioTarea();
    public ControladorTarea(){
        this.tarea = this.servicioTarea.getTarea();
    }
}
