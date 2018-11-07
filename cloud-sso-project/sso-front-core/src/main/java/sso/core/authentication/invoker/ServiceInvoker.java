<<<<<<< HEAD
package sso.core.authentication.invoker;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sso.core.authentication.invoker.spi.IServiceInvoker;
import cloud.sso.domain.ResultData;
import cloud.sso.user.service.api.IUserServiceFeignClient;

@Service
public class ServiceInvoker implements IServiceInvoker{

	@Autowired
	private IUserServiceFeignClient userServiceFacade;
	
	public Long getUserIdByMobile(String mobile) {
		 ResultData resultData = userServiceFacade.getUserIdByLoginId(mobile);
		 if(resultData != null) {
			 return Long.valueOf((String)resultData.getData().get("userId"));
		 }
		 return null;
	}
	
}
=======
package sso.core.authentication.invoker;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sso.core.authentication.invoker.spi.IServiceInvoker;
import cloud.sso.domain.ResultData;
import cloud.sso.user.service.api.IUserServiceFeignClient;

@Service
public class ServiceInvoker implements IServiceInvoker{

	@Autowired
	private IUserServiceFeignClient userServiceFacade;
	
	public Long getUserIdByMobile(String mobile) {
		 ResultData resultData = userServiceFacade.getUserIdByLoginId(mobile);
		 if(resultData != null) {
			 return Long.valueOf((String)resultData.getData().get("userId"));
		 }
		 return null;
	}
	
}
>>>>>>> cloud_sso_branch
