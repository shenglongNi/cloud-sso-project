package sso.core.authentication.invoker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sso.core.authentication.feign.client.UserServiceFacade;
import sso.core.authentication.invoker.spi.IServiceInvoker;
import cloud.sso.domain.ResultData;
import cloud.sso.domain.User;

@Service
public class ServiceInvoker implements IServiceInvoker{

	@Autowired
	private UserServiceFacade userServiceFacade;
	
	public Long getUserIdByMobile(String mobile) {
		 ResultData resultData = userServiceFacade.getUserByLoginId(mobile);
		 if(resultData.getData() != null) {
			 return  Long.valueOf((String) resultData.getData().get("userId"));
		 }
		 return null;
	}
	
	
	public User getUser(Long userId) {
		ResultData resultData = userServiceFacade.getUserInfoByUserId(userId);
		if(resultData.getData() != null) {
			return (User) resultData.getData().get("user");
		}
		
		return null;
	}
	
}
