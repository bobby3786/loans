package com.example.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.loans.dto.LoansContactInfoDto;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "EazyBank Loans Microservice REST API Documentationn",
				version = "v1",
				contact = @Contact(
						name = "bobby yadav",
						email = "bobbyyadav@gmail.com",
						url = "https://www.yotube.com"
						),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.eazybytes.com"
						)
				),
		externalDocs = @ExternalDocumentation(
				description = "Eazy bank Loans microservice REST API Documentation",
				url = "https://www.eazybytes.com/swagger-ui.html"
				)
		)
@EnableConfigurationProperties(value = {LoansContactInfoDto.class})
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansApplication.class, args);
	}

}
