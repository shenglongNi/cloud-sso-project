package sso.core.authentication.invoker;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

import sso.core.authentication.feign.client.UserServiceFacade;
import sso.core.authentication.invoker.spi.IServiceInvoker;
import sso.core.authentication.util.GsonCreator;
import cloud.sso.domain.ResultData;
import cloud.sso.domain.User;

@Service
public class ServiceInvoker implements IServiceInvoker{

	@Autowired
	private UserServiceFacade userServiceFacade;
	
	public Long getUserIdByMobile(String mobile) {
		 String resultData = userServiceFacade.getUserByLoginId(mobile);
		 
		 JSONObject jsonObj = JSONObject.parseObject(resultData);
		 if(jsonObj != null && jsonObj.getJSONObject("data").get("userId") != null) {
			 return  Long.valueOf(jsonObj.getJSONObject("data").getString("userId"));
		 }
		 return null;
	}
	
	
	public User getUser(Long userId) {
		String resultData = userServiceFacade.getUserInfoByUserId(userId);
		JSONObject jsonObj = JSONObject.parseObject(resultData);
		if(jsonObj != null && !jsonObj.getJSONObject("data").isEmpty()) {
			return GsonCreator.createGsonInstance().fromJson(jsonObj.getJSONObject("data").getJSONObject("user").toJSONString(), User.class);
		}
		return null;
	}


	@Override
	public boolean VerifyPwd(Long userId, String pwd) {
		String jsonResult = userServiceFacade.verifyUserPwd(userId, pwd);
		JSONObject jsonObj = JSONObject.parseObject(jsonResult);
		
		if(StringUtils.equals(jsonObj.getString("returnCode"), "000000")) {
			return true;
		}
		
		return false;
	}
	
}
