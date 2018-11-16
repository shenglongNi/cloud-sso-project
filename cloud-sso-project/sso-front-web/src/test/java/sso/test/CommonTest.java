package sso.test;

import org.junit.Test;

public class CommonTest {

	
	@Test
	public void testThreadLocal() {
		
		ThreadLocal<Long> local1 = new ThreadLocal<Long>();
		ThreadLocal<Long> local2 = new ThreadLocal<Long>();
		
		local1.set(2L);
		local2.set(4L);
		
		System.out.println("local1 get:" + local1.get());
		System.out.println("local2 get:" + local2.get());
	}
}
