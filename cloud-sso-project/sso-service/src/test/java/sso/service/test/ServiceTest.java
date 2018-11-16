
package sso.service.test;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sso.service.SsoServiceApplication;
import sso.service.busi.repository.UserMobileRelatedRepository;
import sso.service.busi.repository.UserPwdRepository;
import cloud.sso.domain.UserMobileRelated;
import cloud.sso.domain.UserPwdInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SsoServiceApplication.class})
public class ServiceTest {

	@Autowired
	UserMobileRelatedRepository userMobileRelatedRepository;
	
	@Autowired
	UserPwdRepository userPwdRepository;
	
	@Test
	@Ignore
	public void tesUserMobileRelated() {
		UserMobileRelated result = userMobileRelatedRepository.findByMobile("15788956654");
		System.out.println(result);
		UserMobileRelated related = new UserMobileRelated();
		related.setUserId(10004L);
		related.setMobile("15788956654");
		userMobileRelatedRepository.save(related);
		
	}
	
	@Test
	@Ignore
	public void testUserPwdRepository() {
		UserPwdInfo pwd = new UserPwdInfo();
		
		pwd.setUserId(1001L);
		pwd.setValiDate(new Date());
		pwd.setLoginPwd("111111");
		pwd.setLastSuccTime(new Date());
		pwd.setLoginType(1);
		userPwdRepository.save(pwd);
	}
	
	@Test
	public void testUserPwdRepositoryUpdate() {
		UserPwdInfo userPwdInfo = userPwdRepository.findOne(1001L);
		System.out.println(userPwdInfo);
		userPwdInfo.setCrtTime(new Date());
		userPwdRepository.save(userPwdInfo);
	}
	
}

