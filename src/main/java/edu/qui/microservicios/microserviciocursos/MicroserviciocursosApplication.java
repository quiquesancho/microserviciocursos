package edu.qui.microservicios.microserviciocursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EntityScan("edu.qui.microservicios")
@EnableEurekaClient
public class MicroserviciocursosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciocursosApplication.class, args);
	}

}
