package com.tarea.services;

import com.tarea.entities.Tarea;

import java.time.LocalDate;

public class ServicioTarea {

    Tarea tarea;

    public ServicioTarea() {
        this.tarea = new Tarea(1L,"Tarea1","Tarea",true, LocalDate.now());
    }

    public Tarea getTarea() {
        return tarea;
    }
}
