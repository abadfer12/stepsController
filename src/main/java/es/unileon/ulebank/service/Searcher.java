package es.unileon.ulebank.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.ulebank.handler.Handler;
import es.unileon.ulebank.handler.OfficeHandler;

public class Searcher {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	private String address;
	private String id;

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
		logger.info("Address set to " + address);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
		logger.info("Id set to " + id);
	}

}
