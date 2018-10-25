package sso.test;


import org.jasig.cas.authentication.principal.Service;
import org.jasig.cas.authentication.principal.SimpleWebApplicationServiceImpl;
import org.jasig.cas.services.RegisteredService;
import org.jasig.cas.services.ServiceRegistryDao;
import org.jasig.cas.services.ServicesManager;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sso.cloud.SsoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SsoApplication.class})
public class RegisteredSerivceTest {
	
	@Autowired
	ServiceRegistryDao registryDao;
	
	@Autowired
	ServicesManager servicesManager;
	
	@Test
	public void registryDaoTest() {
		RegisteredService findServiceById = registryDao.findServiceById(1);
		System.out.println(findServiceById);
	}
	
	@Test
	public void testServiceManager() {
		try {
			
			Service service = new SimpleWebApplicationServiceImpl("localhost");
			RegisteredService registryServcie = servicesManager.findServiceBy(service);
			Assert.assertNotNull(registryServcie);
			Assert.assertEquals(1, registryServcie.getId());
			Assert.assertTrue(registryServcie.getAccessStrategy().isServiceAccessAllowed());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
