
package sso.core.authentication.feign.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cloud.sso.domain.ResultData;

@FeignClient(value="sso-service", path="/sso-service")
public interface UserServiceFacade {

	@RequestMapping("/getUserByLoginId")
	ResultData getUserByLoginId(@RequestParam("loginId") String loginId);
	
	@RequestMapping("/getUserInfoById")
	ResultData getUserInfoByUserId(@RequestParam("userId") Long userId);
}
