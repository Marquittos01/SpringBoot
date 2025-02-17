package com.tarea.controllers;

import com.tarea.entities.Tarea;
import com.tarea.services.ServicioTarea;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControladorTarea {

    private ServicioTarea serviciotarea;

    public ControladorTarea(ServicioTarea serviciotarea){
        this.serviciotarea = serviciotarea;
    }


    @GetMapping("/tarea")
    public List<Tarea> getAllTareas(){
        return this.serviciotarea.getAllTareas();
    }

    @GetMapping("/tarea/{id}")
    public Tarea getTarea(@PathVariable Long id){
        return this.serviciotarea.getTarea(id);
    }

    @PostMapping("/tarea")
    public Tarea createTarea(@RequestBody Tarea tarea) {
        return this.serviciotarea.createTarea(tarea);
    }

    @PutMapping("/tarea")
    public Tarea updateTarea(@RequestParam Long id, @RequestBody Tarea tareaDetalles) {
        return this.serviciotarea.updateTarea(id, tareaDetalles);
    }

    @DeleteMapping("/tarea")
    public void deleteTarea(@RequestParam Long id) {
        this.serviciotarea.deleteTarea(id);
    }

}
