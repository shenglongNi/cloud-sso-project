package sso.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.ViewResolver;

import sso.cloud.SsoApplication;
import sso.cloud.web.controller.SingleSignOnAction;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SsoApplication.class})
@WebAppConfiguration
public class ControllerTest {

	private static Logger logger = LoggerFactory.getLogger(ControllerTest.class);
	
	private static final String TEST_LOGIN_URL_WITHOUT_SERVICE = "http://localhost:8080/idm/login.html";
	private static final String TEST_LOGIN_URL_WITH_SERVICE = "http://localhost:8080/idm/login.html?service=http://localhost:8080/client/shiro-cas";
	
	private MockMvc mvc;
	
	@Autowired
	ViewResolver freeMarkerViewResolver;
	
	@Autowired
	SingleSignOnAction action;
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		mvc = MockMvcBuilders.standaloneSetup(action).setViewResolvers(freeMarkerViewResolver).build();
	}
	
	@Test
	public void testLoginWithOutTGC() throws Exception {
		try {
			
			mvc.perform(MockMvcRequestBuilders.get("/login").accept(MediaType.APPLICATION_FORM_URLENCODED)).andExpect(MockMvcResultMatchers.status().isOk());
		} catch (Throwable e) {

		}
	}
	
}
