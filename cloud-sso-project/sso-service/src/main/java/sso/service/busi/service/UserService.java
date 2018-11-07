package sso.service.busi.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sso.service.busi.repository.UserMobileRelatedRepository;
import sso.service.busi.service.spi.IUserService;
import cloud.sso.domain.ResultData;
import cloud.sso.domain.UserMobileRelated;

import com.google.common.collect.Maps;

@Service
public class UserService implements IUserService{

	@Autowired
	private UserMobileRelatedRepository userMobileRelatedRepository;
	
	@Override
	public ResultData getUserIdByLoginId(String loginId) {
		ResultData resultData = new ResultData();
		Map<String, Object> dataMap = Maps.newHashMap();
		UserMobileRelated userMobileRelated = userMobileRelatedRepository.findByMobile(loginId);
		 if(userMobileRelated != null) {
			 dataMap.put("userId", userMobileRelated.getUserId());
			 resultData.setData(dataMap);
			 resultData.setReturnCode("000000");
			 resultData.setReturnMsg("查询成功");
			 return resultData;
		 }
		 resultData.setReturnCode("210000");
		 resultData.setReturnMsg("查询无数据");
		 return resultData;
	}

}
