package es.unileon.ulebank.office;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OfficeTests {

	private Office office;

	@Before
	public void setUp() throws Exception {
		office = new Office("1234", "0123");
	}

	@Test
	public void testSetAndGetAddress() {
		String testAddress = "Ordonyo II";
		assertNull(office.getAddress());
		office.setAddress(testAddress);
		assertEquals(testAddress, office.getAddress());
	}

	@Test
	public void testSetAndGetBalance() {
		int testBalance = 600;
		office.setTotalIncome(800);
		office.setTotalExpenses(200);
		assertEquals(testBalance, office.getBalance(), 0);
	}
}
