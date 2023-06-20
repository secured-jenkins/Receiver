package com.example.completer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.example.configurations", "com.example.services", "com.example.controllers" })
@EntityScan({ "com.example.persistence.entities" })
@EnableJpaRepositories("com.example.persistence")
@EnableDiscoveryClient
public class CompleterApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompleterApplication.class, args);
	}

}
