package es.unileon.ulebank.web;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.ulebank.exceptions.OfficeNotFoundException;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.service.*;

@Controller
@RequestMapping(value = "/searcher.htm")
public class SearcherController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private OfficeManager officeManager;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(@Valid Searcher searcher, BindingResult result)
			throws OfficeNotFoundException {

		String id = searcher.getId();

		if (id == "" || id == null) {

			String now = (new Date()).toString();
			logger.info("Returning hello view with " + now);

			Map<String, Object> myModel = new HashMap<String, Object>();
			myModel.put("now", now);
			myModel.put("offices", this.officeManager.getOffices());

			return new ModelAndView("hello", "model", myModel);
		} else {
			logger.info("Search office with id " + id + ".");

			Office office = this.officeManager.searchOffice(id);

			if (office != null) {
				return new ModelAndView("office", "office", office);
			} else {

				String now = (new Date()).toString();
				logger.info("Returning hello view with " + now);

				Map<String, Object> myModel = new HashMap<String, Object>();
				myModel.put("now", now);
				myModel.put("offices", this.officeManager.getOffices());

				return new ModelAndView("hello", "model", myModel);
			}

		}
	}

	@RequestMapping(method = RequestMethod.GET)
	protected Searcher formBackingObject(HttpServletRequest request)
			throws ServletException {
		Searcher searcher = new Searcher();
		searcher.setId("0000");
		return searcher;
	}

	public void setOfficeManager(OfficeManager officeManager) {
		this.officeManager = officeManager;
	}

	public OfficeManager getOfficeManager() {
		return officeManager;
	}
}
