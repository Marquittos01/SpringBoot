package com.tarea.controllers;

import com.tarea.entities.Tarea;
import com.tarea.services.ServicioTarea;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tarea")
public class ControladorTarea {

    private final ServicioTarea serviciotarea;

    public ControladorTarea(ServicioTarea serviciotarea) {
        this.serviciotarea = serviciotarea;
    }

    @GetMapping
    public ResponseEntity<?> getTarea(@RequestParam(required = false) Long id) {
        if (id == null) {
            List<Tarea> tareas = serviciotarea.getAllTareas();
            if (tareas.isEmpty()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "No hay tareas registradas."));
            }
            return ResponseEntity.ok(tareas);
        } else {
            Tarea tarea = serviciotarea.getTarea(id);
            if (tarea != null) {
                return ResponseEntity.ok(tarea);
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Tarea con ID " + id + " no encontrada."));
            }
        }
    }

    @PostMapping
    public ResponseEntity<?> createTarea(@Valid @RequestBody Tarea tarea) {
        Tarea nuevaTarea = serviciotarea.createTarea(tarea);
        return ResponseEntity.status(HttpStatus.CREATED).body(Map.of("mensaje", "Tarea creada con éxito.", "id", nuevaTarea.getId()));
    }

    @PutMapping
    public ResponseEntity<?> updateTarea(@RequestParam Long id, @Valid @RequestBody Tarea tareaDetalles) {
        Tarea tareaActualizada = serviciotarea.updateTarea(id, tareaDetalles);
        if (tareaActualizada != null) {
            return ResponseEntity.ok(Map.of("mensaje", "Tarea con ID " + id + " actualizada correctamente."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "Tarea con ID " + id + " no encontrada."));
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteTarea(@RequestParam Long id) {
        boolean eliminado = serviciotarea.deleteTarea(id);
        if (eliminado) {
            return ResponseEntity.ok(Map.of("mensaje", "Tarea con ID " + id + " eliminada correctamente."));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "No se pudo eliminar. Tarea con ID " + id + " no encontrada."));
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
    }
}