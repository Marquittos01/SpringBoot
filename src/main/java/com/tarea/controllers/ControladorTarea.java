package com.tarea.controllers;

import com.tarea.entities.Tarea;
import com.tarea.services.ServicioTarea;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.annotation.GetExchange;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ControladorTarea {

    private ServicioTarea serviciotarea;

    public ControladorTarea(ServicioTarea serviciotarea){
        this.serviciotarea = serviciotarea;
    }

    @GetMapping("/tarea")
    public List<Tarea> getTareas(){
        return this.serviciotarea.getAllTareas();
    }

    @GetMapping("/tarea/{id}")
    public Tarea getTarea(@PathVariable Long id){
        return this.serviciotarea.getTarea(id);
    }

    @PostMapping("/tarea")
    public Tarea insertarTarea(@RequestBody Tarea nuevaTarea) {
        return this.serviciotarea.insertarTarea(nuevaTarea);
    }

    @PutMapping("/tarea")
    public boolean modificarTarea(Long id, String nombre, String descripcion, LocalDate fecha, Boolean estado){
        return this.serviciotarea.actualizarTarea(id, nombre, descripcion,fecha,estado);
    }
}
