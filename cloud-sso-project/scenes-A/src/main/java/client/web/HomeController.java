package client.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(HttpServletRequest request, HttpServletResponse response) {
		return request.getRemoteUser();
	}
	
}
