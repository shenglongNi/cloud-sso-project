
package sso.core.authentication.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import sso.core.authentication.feign.hystrixfallback.UserServiceFallback;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import cloud.sso.domain.ResultData;

@FeignClient(value="sso-service", path="/sso-service", fallback=UserServiceFallback.class)
public interface UserServiceFacade {
	@HystrixCommand
	@RequestMapping("/getUserByLoginId")
	String getUserByLoginId(@RequestParam("loginId") String loginId);
	
	@HystrixCommand
	@RequestMapping("/getUserInfoById")
	String getUserInfoByUserId(@RequestParam("userId") Long userId);
	
	@HystrixCommand
	@RequestMapping("/verifyPwd")
	String verifyUserPwd(@RequestParam("userId") Long userId, @RequestParam("pwd") String pwd);
}
