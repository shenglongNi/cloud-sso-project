package sso.core.authentication.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cloud.sso.domain.ResultData;

@FeignClient("sso-service")
public interface UserServiceFacade {

	@RequestMapping("/sso-service/getUserByLoginId")
	ResultData getUserByLoginId(@RequestParam("loginId") String loginId);
	
	
}
