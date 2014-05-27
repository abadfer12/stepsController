package es.unileon.ulebank.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.unileon.ulebank.office.Office;

@Repository(value = "OfficeDao")
public class JPAOfficeDao implements OfficeDao {

	private EntityManager em = null;

	/*
	 * Sets the entity manager.
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager em) {
		this.em = em;
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Office> getOfficeList() {
		return em.createQuery("select o from Office o order by o.id").getResultList();
		//return em.createQuery("select p from Product p order by p.id").getResultList();
	}

	@Transactional(readOnly = true)
	@SuppressWarnings("unchecked")
	public List<Office> searchOffice(String idOffice) {
		return em.createQuery("select * from offices WHERE idOffice=idOffice")
				.getResultList();
	}
	
	 @Transactional(readOnly = false)
	    public void saveOffice(Office of) {
	        em.merge(of);
	    }
}
