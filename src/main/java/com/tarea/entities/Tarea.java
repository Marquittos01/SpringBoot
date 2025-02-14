package com.tarea.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="Tarea")
public class Tarea {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="nombre")
    private String name;
    @Column(name="descripcion")
    private String description;
    @Column(name="estado")
    private boolean status;
    @Column(name="fecha")
    private LocalDate date;

    public Tarea(){

    }

    public Tarea(Long id,String name, String description, boolean status, LocalDate date){
        this.id=id;
        this.name=name;
        this.description=description;
        this.status=status;
        this.date=date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Tarea{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", date=" + date +
                '}';
    }
}