package sso.service.busi.service.spi;

import cloud.sso.domain.ResultData;

public interface IUserService {
	
	ResultData getUserIdByLoginId(String loginId);
	
	ResultData getUserInfoByUserId(Long userId);
	
	ResultData verifyUserPwd(Long userId, String pwd);
}
