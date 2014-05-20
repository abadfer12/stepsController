package es.unileon.ulebank.service;

import java.util.ArrayList;
import java.util.List;

import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.OfficeHandler;
import es.unileon.ulebank.exceptions.MalformedHandlerException;
import es.unileon.ulebank.exceptions.OfficeNotFoundException;

//import java.util.ArrayList;

public class Bank implements OfficeManager {

	private static final long serialVersionUID = 1L;
	private List<Office> offices = new ArrayList<Office>();
	private final Handler idBank;

	/**
	 *
	 * @param manager
	 * @param bankID
	 * @throws MalformedHandlerException
	 */
	public Bank(String idBank) throws MalformedHandlerException {
		this.idBank = new BankHandler(idBank);
		// this.offices = new ArrayList<Office>();
	}

	public List<Office> getOffices() {
		if (offices.isEmpty() == true) {
			return null;
		} else {
			return offices;
		}
	}

	public void setOffices(List<Office> offices) {
		this.offices = offices;
	}

	public Handler getIdBank() {
		return idBank;
	}

	/**
	 *
	 * @param office
	 * @return
	 */
	public boolean addOffice(Office office) {
		if (office != null) {
			for (int i = 0; i < offices.size(); ++i) {
				if (offices.get(i).getIdOffice()
						.compareTo(office.getIdOffice()) == 0) {
					return false;
				}
			}
			return this.offices.add(office);
		}
		return false;
	}

	/**
	 *
	 * @param office
	 * @return
	 */
	public boolean removeOffice(Handler office) {
		boolean removed = false;
		if (office != null) {
			for (int i = 0; i < offices.size() && !removed; ++i) {
				if (offices.get(i).getIdOffice().compareTo(office) == 0) {
					this.offices.remove(i);
					removed = true;
				}
			}
		}
		return removed;
	}

	public Office searchOffice(String id) throws OfficeNotFoundException {

		Handler idHandler = new OfficeHandler(id);
		Office office = null;
		int i = 0;
		boolean found = false;

		if (!offices.isEmpty()) {
			while (found == false && i < offices.size()) {

				if (offices.get(i).getIdOffice().compareTo(idHandler) == 0) {
					found = true;
					office = offices.get(i);
				}
				i++;
			}
		} else {
			throw new OfficeNotFoundException("Empty list.");
		}
		if (found == true) {
			return office;
		} else {
			throw new OfficeNotFoundException("Office not founded.");
		}

	}

	// @Override
	// public Office searchOffice(String address) {
	// Office office = null;
	// if (offices != null) {
	// for (int i = 0; i < offices.size(); i++) {
	// if (offices.get(i).getAddress().compareTo(address) == 0) {
	// office = offices.get(i);
	//
	// }
	// }
	// }
	// return office;
	//
	// }

}
