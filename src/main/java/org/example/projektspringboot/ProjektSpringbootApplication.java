package org.example.projektspringboot;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(info = @Info(title = "My API", version = "1.0", description = "My API for managing contracts"))

@SpringBootApplication
public class ProjektSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjektSpringbootApplication.class, args);
    }

}
