package edu.qui.microservicios.microserviciocursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("edu.qui.microservicios")
public class MicroserviciocursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciocursosApplication.class, args);
	}

}
