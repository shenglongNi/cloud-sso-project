package sso.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages={"cloud.sso.repository"})
@EntityScan(basePackages = {"cloud.sso.domain"})
public class SsoServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SsoServiceApplication.class, args);
	}
}
