package cloud.sso.user.service.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cloud.sso.domain.ResultData;
/**
 * 为了降低模块间的耦合度， 不建议将FeignClient 写在公用api中。
 * @author Administrator
 *
 */
@FeignClient(name="sso-service")
public interface IUserServiceFeignClient {

	@RequestMapping("/getUserByLoginId")
	ResultData getUserIdByLoginId(@RequestParam("loginId") String loginId);
}
