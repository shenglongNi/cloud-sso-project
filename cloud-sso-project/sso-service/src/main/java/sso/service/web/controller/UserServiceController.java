package sso.service.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sso.service.busi.service.UserService;
import cloud.sso.domain.ResultData;

@RestController
public class UserServiceController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/getUserByLoginId")
	public ResultData getUserIdByLoginId(@RequestParam("loginId") String login) {
		
		return userService.getUserIdByLoginId(login);
	}
}
