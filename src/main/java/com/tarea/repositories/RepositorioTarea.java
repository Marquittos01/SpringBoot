package com.tarea.repositories;

import com.tarea.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioTarea extends JpaRepository<Tarea,Long> {
}
