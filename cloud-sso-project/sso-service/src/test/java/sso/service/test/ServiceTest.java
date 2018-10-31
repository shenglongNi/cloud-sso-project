package sso.service.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cloud.sso.domain.UserMobileRelated;
import cloud.sso.repository.UserMobileRelatedRepository;
import sso.service.SsoServiceApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {SsoServiceApplication.class})
public class ServiceTest {

	@Autowired
	UserMobileRelatedRepository userMobileRelatedRepository;
	
	@Test
	@Ignore
	public void tesUserMobileRelated() {
		UserMobileRelated result = userMobileRelatedRepository.findByMobile("15788956654");
		System.out.println(result);
//		UserMobileRelated related = new UserMobileRelated();
//		related.setUserId(10004L);
//		related.setMobile("15788956654");
//		userMobileRelatedRepository.save(related);
		
	}
	
}
