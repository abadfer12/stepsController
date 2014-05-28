package es.unileon.ulebank.repository;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.office.Office;

public class JPAOfficeDaoTests {

	private ApplicationContext context;
	private OfficeDao officeDao;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(
				"classpath:test-context.xml");
		officeDao = (OfficeDao) context.getBean("officeDao");
	}

	@Test
	public void testGetOfficeList() {

		List<Office> offices = officeDao.getOfficeList();
		assertEquals(offices.size(), 3, 0);
	}

	@Test
	public void testSaveOffice() {
		List<Office> offices = officeDao.getOfficeList();

		Office p = offices.get(0);
		Double balance = p.getBalance();
		p.setBalance(200.0);
		officeDao.saveOffice(p);

		List<Office> updatedOffices = officeDao.getOfficeList();
		Office p2 = updatedOffices.get(0);
		assertEquals(p2.getBalance(), 200.0, 0);

		p2.setBalance(balance);
		officeDao.saveOffice(p2);
	}
}