package com.tarea.entities;


import java.time.LocalDate;

public class Tarea {
    Long id;
    String name;
    String description;
    Boolean status;
    LocalDate fecha;

    public Tarea() {

        this.id = null;
        this.name = null;
        this.description = null;
        this.status = false;
        this.fecha = LocalDate.now();

    }

    public Tarea(Long id, String name, String description, Boolean status, LocalDate fecha) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.fecha = fecha;
    }
}
