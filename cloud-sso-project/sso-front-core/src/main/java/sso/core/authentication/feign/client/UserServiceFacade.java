
package sso.core.authentication.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cloud.sso.domain.ResultData;

@FeignClient(value="sso-service", path="/sso-service")
public interface UserServiceFacade {

	@RequestMapping("/getUserByLoginId")
	String getUserByLoginId(@RequestParam("loginId") String loginId);
	
	@RequestMapping("/getUserInfoById")
	String getUserInfoByUserId(@RequestParam("userId") Long userId);
	
	@RequestMapping("/verifyPwd")
	String verifyUserPwd(@RequestParam("userId") Long userId, @RequestParam("pwd") String pwd);
}
