package sso.cloud.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OkController {

	@RequestMapping("/")
	public String Ok() {
		return "ok";
	}
	
	@RequestMapping("/exception")
	public String exception() {
		
		throw new RuntimeException();
	}
	
	@Value("${sso.front.web.test}")
	private String config;
	@RequestMapping("/configtest")
	public String testConfig() {
		
		return "config value : " + config;
	}
}
