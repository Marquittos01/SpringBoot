package com.tarea.controllers;

import com.tarea.entities.Tarea;
import com.tarea.services.ServicioTarea;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class ControladorTarea {

    private ServicioTarea serviciotarea;

    public ControladorTarea(ServicioTarea serviciotarea){
        this.serviciotarea = serviciotarea;
    }


    @GetMapping("/tarea")
    public ResponseEntity<?> getTarea(@RequestParam(required = false) Long id) {
        if (id == null) {
            return ResponseEntity.ok(this.serviciotarea.getAllTareas());
        } else {
            Tarea tarea = this.serviciotarea.getTarea(id);
            if (tarea != null) {
                return ResponseEntity.ok(tarea);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body("Tarea con id " + id + " no encontrada");
            }
        }
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
