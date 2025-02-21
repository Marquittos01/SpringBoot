package com.tarea.controllers;

import com.tarea.entities.Tarea;
import com.tarea.services.ServicioTarea;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
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
                        .body("Error: Tarea con ID " + id + " no encontrada.");
            }
        }
    }

    @PostMapping("/tarea")
    public ResponseEntity<?> createTarea(@RequestBody Tarea tarea) {
        Tarea nuevaTarea = this.serviciotarea.createTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Tarea creada con éxito. ID: " + nuevaTarea.getId());
    }

    @PutMapping("/tarea")
    public ResponseEntity<?> updateTarea(@RequestParam Long id, @RequestBody Tarea tareaDetalles) {
        Tarea tareaActualizada = this.serviciotarea.updateTarea(id, tareaDetalles);
        if (tareaActualizada != null) {
            return ResponseEntity.ok("Tarea con ID " + id + " actualizada correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: Tarea con ID " + id + " no encontrada.");
        }
    }

    @DeleteMapping("/tarea")
    public ResponseEntity<?> deleteTarea(@RequestParam Long id) {
        boolean eliminado = this.serviciotarea.deleteTarea(id);
        if (eliminado) {
            return ResponseEntity.ok("Tarea con ID " + id + " eliminada correctamente.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Error: No se pudo eliminar. Tarea con ID " + id + " no encontrada.");
        }
    }

}
