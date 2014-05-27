package es.unileon.ulebank.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import es.unileon.ulebank.exceptions.OfficeNotFoundException;
import es.unileon.ulebank.office.Office;

public class BankTests {

	private Bank bank;

	private List<Office> offices;

	private static int OFFICE_COUNT = 2;

	private static String OFFICE_1_ID = "1234";
	private static int OFFICE_1_BALANCE = 700;
	private static String OFFICE_1_ADDRESS = "Ordonyo II";

	private static String OFFICE_2_ID = "5678";
	private static String OFFICE_2_ADDRESS = "Calle ancha";
	private static int OFFICE_2_BALANCE = 600;

	@Before
	public void setUp() throws Exception {
		bank = new Bank("0123");

		offices = new ArrayList<Office>();

		// stub up a list of products
		Office office = new Office("1234", "0123");
		office.setAddress("Ordonyo II");
		office.setBalance(700);
		offices.add(office);

		office = new Office("5678", "0123");
		office.setAddress("Calle ancha");
		office.setBalance(600);
		offices.add(office);

		bank.setOffices(offices);
	}

	@Test
	public void testGetOfficesWithNoOffices() {
		bank = new Bank("0123");
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

	@Test(expected = OfficeNotFoundException.class)
	public void testIncreasePriceWithNullListOfOffices()
			throws OfficeNotFoundException {
		// try {
		bank = new Bank("2345");
		bank.searchOffice("0123");
		// } catch (NullPointerException ex) {
		// fail("Offices list is null.");
		// }
	}

	@Test(expected = OfficeNotFoundException.class)
	public void testSearchOfficeWithEmptyListOfOffices()

	throws OfficeNotFoundException {
		// try {
		bank = new Bank("2223");
		bank.setOffices(new ArrayList<Office>());
		bank.searchOffice("1234");

		// } catch (Exception ex) {
		// fail("Offices list is empty.");
		// }
	}

	@Test
	public void testSearchOfficeWithGoodId() throws OfficeNotFoundException {
		Office office1 = bank.searchOffice(OFFICE_1_ID);
		Office office2 = bank.searchOffice(OFFICE_2_ID);
		String expectedId1 = OFFICE_1_ID;
		String expectedId2 = OFFICE_2_ID;
		assertEquals(expectedId1, office1.getIdOffice().toString());
		assertEquals(expectedId2, office2.getIdOffice().toString());
	}

}
