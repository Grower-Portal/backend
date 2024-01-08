package com.growerportal.GrowerPortal;

import com.growerportal.GrowerPortal.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableJpaRepositories
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class GrowerPortalApplication {
	public static void main(String[] args) {
		SpringApplication.run(GrowerPortalApplication.class, args);
	}

}
