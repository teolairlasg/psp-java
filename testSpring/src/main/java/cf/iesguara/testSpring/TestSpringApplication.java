package cf.iesguara.testSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
<<<<<<< HEAD
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
=======
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import cf.iesguara.testSpring.model.Aula;

@SpringBootApplication
//Esto es algo que el año pasado no hacía falta poner. 
//Esto le dice a Spring que escanee componentes en este paquete y todos sus subpaquetes
//
@ComponentScan()
>>>>>>> ce8e639 (uploading local changes)
public class TestSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestSpringApplication.class, args);
	}

}
