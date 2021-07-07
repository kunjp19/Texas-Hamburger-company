package com.example.passport.thc;

import com.example.passport.thc.configuration.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@Import(SwaggerConfiguration.class)
public class ThcApplication {
	public static void main(String[] args) {
		SpringApplication.run(ThcApplication.class, args);
	}
}
