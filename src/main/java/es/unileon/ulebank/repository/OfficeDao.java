package es.unileon.ulebank.repository;

import java.util.List;

import es.unileon.ulebank.office.Office;

public interface OfficeDao {

    public List<Office> getOfficeList();

    public void saveOffice(Office off);

}