package com.tarea;

import com.tarea.entities.Tarea;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Tarea tarea = new Tarea();
		Tarea tarea2 = new Tarea(1L,"caballa","fresca",true, LocalDate.now());
	}

}
