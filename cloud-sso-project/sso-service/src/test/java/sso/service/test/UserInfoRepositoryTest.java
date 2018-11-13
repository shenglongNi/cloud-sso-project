package sso.service.test;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cloud.sso.domain.User;
import sso.service.SsoServiceApplication;
import sso.service.busi.repository.UserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SsoServiceApplication.class})
public class UserInfoRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Test
	@Ignore
	public void testSave() {
		User user = new User();
		user.setUsername("Vicky");
		user.setEmail("1509043059@qq.com");
		user.setSex(0);
		user.setMobile("15655784490");
//		userRepository.save(user);
	}
	
	@Test
	@Ignore
	public void testQuery() {
		User user = userRepository.findByUserId(10004L);
		System.out.println(user);
	}
}
