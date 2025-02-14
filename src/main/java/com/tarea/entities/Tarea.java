package com.tarea.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "nombre")
    String name;
    @Column(name = "descripcion")
    String description;
    @Column(name = "estado")
    Boolean status;
    @Column(name = "fecha")
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
