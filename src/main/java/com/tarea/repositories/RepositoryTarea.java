package com.tarea.repositories;

import com.tarea.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTarea extends JpaRepository<Tarea, Long> {

}
