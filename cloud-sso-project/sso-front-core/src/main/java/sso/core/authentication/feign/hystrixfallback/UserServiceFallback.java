package sso.core.authentication.feign.hystrixfallback;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

import sso.core.authentication.feign.client.UserServiceFacade;

@Component
public class UserServiceFallback implements UserServiceFacade{

	@Override
	public String getUserByLoginId(@RequestParam("loginId") String loginId) {
		return "error";
	}

	@Override
	public String getUserInfoByUserId(@RequestParam("userId") Long userId) {
		return "error";
	}

	@Override
	public String verifyUserPwd(@RequestParam("userId")  Long userId, @RequestParam("pwd") String pwd) {
		return "error";
	}

}
