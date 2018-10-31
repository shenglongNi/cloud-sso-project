package sso.test;

import static org.hamcrest.CoreMatchers.equalTo;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ViewResolver;

import sso.cloud.SsoApplication;
import sso.cloud.web.controller.SingleSignOnAction;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SsoApplication.class})
@WebAppConfiguration
@AutoConfigureMockMvc
public class ControllerTest {

	
	private static final String TEST_LOGIN_URL_WITHOUT_SERVICE = "http://localhost:8080/idm/login.html";
	private static final String TEST_LOGIN_URL_WITH_SERVICE = "http://localhost:8080/idm/login.html?service=http://localhost:8080/client/shiro-cas";
	
	private MockMvc mvc;
	
	@Autowired
	ViewResolver freeMarkerViewResolver;
	
	@Autowired
	SingleSignOnAction action;
	
	@Autowired
	private WebApplicationContext WebApplicationContext;
	/**
	 * Controller test 需要注入WebApplicationContext
	 * 构建MockMvc 时需要通过 MockMvcBuilders.webAppContextSetup(WebApplicationContext).build() 
	 * 
	 * 有视图返回的要注入ViewResolver
	 */
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.webAppContextSetup(WebApplicationContext).build();
	}
	
	@Test
	@Ignore
	public void testLoginWithoutTGCAndService() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/login").accept(MediaType.APPLICATION_FORM_URLENCODED))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.content().string(equalTo("login page")));
	}
	
	@Test
	@Ignore
	public void testLoginWithoutTGC() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("/login?service=http://localhost:8080/idm/test")
				.accept(MediaType.APPLICATION_FORM_URLENCODED));
	}
	
	@Test
	@Ignore
	public void testnloginWithTGCNoService() {
		
	}
	
}
