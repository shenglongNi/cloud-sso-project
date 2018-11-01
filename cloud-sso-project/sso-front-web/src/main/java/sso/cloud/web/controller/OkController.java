package sso.cloud.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OkController {

	@RequestMapping("/")
	public String Ok() {
		return "ok";
	}
	
	@RequestMapping("/exception")
	public String exception() {
		
		throw new RuntimeException();
	}
}
