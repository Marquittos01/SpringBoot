package com.tarea.controllers;

import com.tarea.entities.Tarea;
import com.tarea.services.ServicioTarea;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Validated
public class ControladorTarea {

    private final ServicioTarea serviciotarea;

    public ControladorTarea(ServicioTarea serviciotarea) {
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
                Map<String, String> response = new HashMap<>();
                response.put("message", "Error: Tarea con ID " + id + " no encontrada.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        }
    }

    @PostMapping("/tarea")
    public ResponseEntity<?> createTarea(@Valid @RequestBody Tarea tarea) {
        Tarea nuevaTarea = this.serviciotarea.createTarea(tarea);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Tarea creada con éxito.");
        response.put("id", nuevaTarea.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/tarea")
    public ResponseEntity<?> updateTarea(@RequestParam Long id, @Valid @RequestBody Tarea tareaDetalles) {
        Tarea tareaActualizada = this.serviciotarea.updateTarea(id, tareaDetalles);
        if (tareaActualizada != null) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Tarea con ID " + id + " actualizada correctamente.");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Error: Tarea con ID " + id + " no encontrada.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @DeleteMapping("/tarea")
    public ResponseEntity<?> deleteTarea(@RequestParam Long id) {
        boolean eliminado = this.serviciotarea.deleteTarea(id);
        if (eliminado) {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Tarea con ID " + id + " eliminada correctamente.");
            return ResponseEntity.ok(response);
        } else {
            Map<String, String> response = new HashMap<>();
            response.put("message", "Error: No se pudo eliminar. Tarea con ID " + id + " no encontrada.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<?> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return ResponseEntity.badRequest().body(errors);
    }
}