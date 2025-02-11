package com.tarea;

import com.tarea.entities.Tarea;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		Tarea t = new Tarea(12L,"gred","urnicmde", true, LocalDate.now());

	}

}
