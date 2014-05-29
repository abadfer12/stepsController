package es.unileon.ulebank.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import es.unileon.ulebank.office.Office;

import es.unileon.ulebank.repository.*;

public class BankTests {

	private Bank bank;

	private List<Office> offices;

	private static int OFFICE_COUNT = 2;

	private static String OFFICE_1_ID = "1234";
	private static Double OFFICE_1_BALANCE = 700.0;
	private static String OFFICE_1_ADDRESS = "Ordonyo II";

	private static String OFFICE_2_ID = "5678";
	private static String OFFICE_2_ADDRESS = "Calle ancha";
	private static Double OFFICE_2_BALANCE = 600.0;

	@Before
	public void setUp() throws Exception {
		bank = new Bank();
		offices = new ArrayList<Office>();

		// stub up a list of products
		Office office = new Office();
		office.setIdOffice("1234");
		office.setAddress("Ordonyo II");
		office.setBalance(700.0);
		offices.add(office);

		office = new Office();
		office.setIdOffice("5678");
		office.setAddress("Calle ancha");
		office.setBalance(600.0);
		offices.add(office);

		OfficeDao officeDao = new InMemoryOfficeDao(offices);
		bank.setOfficeDao(officeDao);
	}

	@Test
	public void testGetOfficesWithNoOffices() {
		bank = new Bank();
		bank.setOfficeDao(new InMemoryOfficeDao(null));
		assertNull(bank.getOffices());
	}

	@Test
	public void testGetProducts() {
		List<Office> offices = bank.getOffices();
		assertNotNull(offices);
		assertEquals(OFFICE_COUNT, bank.getOffices().size());

		Office office = offices.get(0);
		assertEquals(OFFICE_1_ADDRESS, office.getAddress());
		assertEquals(OFFICE_1_BALANCE, office.getBalance());

		office = offices.get(1);
		assertEquals(OFFICE_2_ADDRESS, office.getAddress());
		assertEquals(OFFICE_2_BALANCE, office.getBalance());
	}

	@Test
	public void testSearchOfficeWithGoodId() {

		Office office1 = bank.searchOffice(OFFICE_1_ID);
		Office office2 = bank.searchOffice(OFFICE_2_ID);
		String expectedId1 = OFFICE_1_ID;
		String expectedId2 = OFFICE_2_ID;

		assertEquals(expectedId1, office1.getIdOffice().toString());
		assertEquals(expectedId2, office2.getIdOffice().toString());
	}
}
