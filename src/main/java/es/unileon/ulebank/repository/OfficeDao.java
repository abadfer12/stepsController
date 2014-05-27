package es.unileon.ulebank.repository;

import java.util.List;
import es.unileon.ulebank.office.*;

public interface OfficeDao {

	public List<Office> getOfficeList();

	// public List<Office> searchOffice(String idOffice);

	public void saveOffice(Office of);
}
