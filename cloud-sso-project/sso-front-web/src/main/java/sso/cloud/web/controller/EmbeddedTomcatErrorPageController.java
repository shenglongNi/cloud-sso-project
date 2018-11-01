package sso.cloud.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/errorpage")
public class EmbeddedTomcatErrorPageController {

	@RequestMapping("/404")
	public String error_404() {
		return "error/404";
	}
	
	@RequestMapping("/500")
	public String error_500() {
		return "error/500";
	}
}