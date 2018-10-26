package sso.test;

import org.jasig.cas.CentralAuthenticationService;
import org.jasig.cas.authentication.Credential;
import org.jasig.cas.authentication.UsernamePasswordCredential;
import org.jasig.cas.authentication.principal.Service;
import org.jasig.cas.authentication.principal.SimpleWebApplicationServiceImpl;
import org.jasig.cas.ticket.ServiceTicket;
import org.jasig.cas.ticket.TicketGrantingTicket;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import sso.cloud.SsoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={SsoApplication.class})
public class CentralAuthenticationServiceTest {

	
	@Autowired
	CentralAuthenticationService centraAuthenticationService;
	
	@Test
	public void testCreateTicketGrantingTicket() {
		try {
			
			Credential credentials = new UsernamePasswordCredential("nsl", "891106");
			
			TicketGrantingTicket ticketGrantingTicket = centraAuthenticationService.createTicketGrantingTicket(credentials);
			System.out.println("TicketGreantingTicketId : "  + ticketGrantingTicket.getId());
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void testCreateServiceTicket() {
		try {
			
			Credential credentials = new UsernamePasswordCredential("nsl", "891106");
			
			TicketGrantingTicket ticketGrantingTicket = centraAuthenticationService.createTicketGrantingTicket(credentials);
			System.out.println("TicketGreantingTicketId : "  + ticketGrantingTicket.getId());
			
			String url = "http://localhost:8080/test/shiro-cas";
			Service service = new SimpleWebApplicationServiceImpl(url);
			ServiceTicket serviceTicket = centraAuthenticationService.grantServiceTicket(ticketGrantingTicket.getId(), service);
			System.out.println("Service Ticket : " + serviceTicket.getId());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
}
