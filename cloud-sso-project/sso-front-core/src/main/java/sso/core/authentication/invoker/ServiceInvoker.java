package sso.core.authentication.invoker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sso.core.authentication.feign.client.UserServiceFacade;
import sso.core.authentication.invoker.spi.IServiceInvoker;
import cloud.sso.domain.ResultData;

@Service
public class ServiceInvoker implements IServiceInvoker{

	@Autowired
	private UserServiceFacade userServiceFacade;
	
	public Long getUserIdByMobile(String mobile) {
		 ResultData resultData = userServiceFacade.getUserByLoginId(mobile);
		 if(resultData != null) {
			 return Long.valueOf((String)resultData.getData().get("userId"));
		 }
		 return null;
	}
	
}
