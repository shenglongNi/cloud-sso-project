package sso.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sso.service.busi.service.spi.ICustomService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomRepostoryTest {

	
	@Autowired
	private ICustomService customService;
	
	@Test
	public void testCustomRepository() {
		
		String result = customService.getString(1L);
		
		System.out.println("================result::" + result);
	}
	
}
