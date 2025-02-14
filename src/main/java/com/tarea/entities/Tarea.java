package com.tarea.entities;

import java.time.LocalDate;

public class Tarea {
    Long id;
    String name;
    String description;
    Boolean status;
    LocalDate date;

    public Tarea(){
        this.id = null;
        this.name = "";
        this.description = "";
        this.status = false;
        this.date = LocalDate.now();
    }

    public Tarea(Long id, String name, String description, Boolean status, LocalDate date){
        this.id = id;
        this.name = name;
        this.description = description;
        this.status = status;
        this.date = date;
    }
}
