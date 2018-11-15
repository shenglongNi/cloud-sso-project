package sso.service.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import sso.service.busi.service.UserService;
import cloud.sso.api.DataExchange;
import cloud.sso.domain.ResultData;

@RestController
public class UserServiceController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private DataExchange dataExchange;
	
	@RequestMapping("/getUserByLoginId")
	public String getUserIdByLoginId(@RequestParam("loginId") String login) {
		
		return dataExchange.jsonSerial(userService.getUserIdByLoginId(login));
	}
	
	
	@RequestMapping("/getUserInfoById")
	public String getUserByUserId(@RequestParam("userId") Long userId) {
		
		return dataExchange.jsonSerial(userService.getUserInfoByUserId(userId));
	}
}
