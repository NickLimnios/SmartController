package com.jcs.smc.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.jcs.smc.entity")
@ComponentScan({"com.jcs.smc.controller","com.jcs.smc.service"})
@EnableJpaRepositories("com.jcs.smc.repository")
@SpringBootApplication
public class SmcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmcApplication.class, args);
	}
}
