package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.office.Office;

public class InMemoryOfficeDao implements OfficeDao {

	private List<Office> officeList;

	public InMemoryOfficeDao(List<Office> productList) {
		this.officeList = productList;
	}

	public List<Office> getOfficeList() {
		return officeList;
	}

	public void saveOffice(Office off) {
	}
}
