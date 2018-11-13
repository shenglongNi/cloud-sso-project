package sso.service.busi.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sso.service.busi.repository.UserInfoRepository;
import sso.service.busi.repository.UserMobileRelatedRepository;
import sso.service.busi.service.spi.IUserService;
import cloud.sso.domain.ResultData;
import cloud.sso.domain.User;
import cloud.sso.domain.UserMobileRelated;

import com.google.common.collect.Maps;

@Service
public class UserService implements IUserService{

//	@Autowired
//	private UserMobileRelatedRepository userMobileRelatedRepository;
//	
//	@Autowired
//	private UserInfoRepository userInfoRepository;
	
	@Override
	public ResultData getUserIdByLoginId(String loginId) {
		ResultData resultData = new ResultData();
		/*Map<String, Object> dataMap = Maps.newHashMap();
		UserMobileRelated userMobileRelated = userMobileRelatedRepository.findByMobile(loginId);
		 if(userMobileRelated != null) {
			 dataMap.put("userId", String.valueOf(userMobileRelated.getUserId()));
			 resultData.setData(dataMap);
			 resultData.setReturnCode("000000");
			 resultData.setReturnMsg("查询成功");
			 return resultData;
		 }
		 resultData.setReturnCode("210000");
		 resultData.setReturnMsg("查询无数据");*/
		 return resultData;
	}

	@Override
	public ResultData getUserInfoByUserId(Long userId) {
		
		ResultData resultData = new ResultData();
		/*Map<String, Object> dataMap = Maps.newHashMap();
		
		User user = userInfoRepository.findByUserId(userId);
		
		if(user != null) {
			dataMap.put("user", user);
			resultData.setData(dataMap);
			resultData.setReturnCode("000000");
			resultData.setReturnMsg("查询成功！");
		}
		resultData.setReturnCode("210000");
		resultData.setReturnMsg("查询无数据");*/
		return resultData;
	}
	
}
