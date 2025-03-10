package com.tarea.repositories;

import com.tarea.entities.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryTarea extends JpaRepository<Tarea, Long> {

}
