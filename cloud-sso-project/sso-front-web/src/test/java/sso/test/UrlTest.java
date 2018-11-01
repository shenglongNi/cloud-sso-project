package sso.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Ignore;
import org.junit.Test;

public class UrlTest {

	@Test
	@Ignore
	public void test() throws MalformedURLException {
		
		String serviceId = "http://localhost:8080/idm/test";
		
		System.out.println(new URL(serviceId).getHost());
		
	}
}
