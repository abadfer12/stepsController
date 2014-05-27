package es.unileon.ulebank.repository;

import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import es.unileon.ulebank.office.*;

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
		System.out.println(offices.size());
		assertEquals(offices.size(), 3, 0);
	}

	@Test
	public void testSearchProduct() {
		List<Office> offices = officeDao.getOfficeList();

		Office of = offices.get(0);
		String address = of.getAddress();
		List<Office> office = officeDao.searchOffice("1234");

		assertEquals(address, office.get(0).getAddress());

	} 
	
	@Test
    public void testSaveProduct() {
        List<Office> products = officeDao.getOfficeList();

        Office o = products.get(0);
        String address = o.getAddress();
        o.setAddress("Santo domingo");
        officeDao.saveOffice(o);

        List<Office> updatedProducts = officeDao.getOfficeList();
        Office o2 = updatedProducts.get(0);
        assertEquals(o2.getAddress(), "Santo domingo", 0);

        o2.setAddress("Av Peregrinos");
        officeDao.saveOffice(o2);
    }

}
