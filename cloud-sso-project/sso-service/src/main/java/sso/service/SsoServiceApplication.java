package sso.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@SpringBootApplication
@EnableJpaRepositories(basePackages={"sso.service.busi.*"})
@EntityScan(basePackages = {"cloud.sso.*"})
public class SsoServiceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SsoServiceApplication.class, args);
	}
}
