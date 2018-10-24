package sso.test;

import org.jasig.cas.util.DefaultUniqueTicketIdGenerator;
import org.jasig.cas.util.UniqueTicketIdGenerator;
import org.junit.Test;

public class UniqueTicketGeneratorTest {

	private UniqueTicketIdGenerator ticketGenerator = new DefaultUniqueTicketIdGenerator();
	
	@Test
	public void testUniqueTicketGeneratorTest() {
		String ticketId = ticketGenerator.getNewTicketId("ST");
		System.out.println(ticketId);
	}
	
}
