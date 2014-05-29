package es.unileon.ulebank.service;

import java.util.ArrayList;
import java.util.List;

import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.repository.OfficeDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Bank implements OfficeManager {

	private static final long serialVersionUID = 1L;
	private List<Office> offices = new ArrayList<Office>();
	@Autowired
	private OfficeDao officeDao;

	public List<Office> getOffices() {
		return officeDao.getOfficeList();
	}

	public void setOfficeDao(OfficeDao officeDao) {
		this.officeDao = officeDao;
	}

	public Office searchOffice(String id) {
		offices = officeDao.getOfficeList();
		Office office = null;
		int i = 0;
		boolean found = false;

		if (!offices.isEmpty()) {
			while (found == false && i < offices.size()) {

				if (offices.get(i).getIdOffice().compareTo(id) == 0) {
					found = true;
					office = offices.get(i);
				}
				i++;
			}
		}
		officeDao.saveOffice(office);
		return office;
	}
}
