package com.growerportal.GrowerPortal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class GrowerPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(GrowerPortalApplication.class, args);
	}

}
