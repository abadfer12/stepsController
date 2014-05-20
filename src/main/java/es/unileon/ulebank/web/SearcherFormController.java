package es.unileon.ulebank.web;

import java.io.IOException;
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
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import es.unileon.ulebank.exceptions.OfficeNotFoundException;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.service.*;

@Controller
@RequestMapping(value = "/searcher.htm")
public class SearcherFormController {

	/** Logger for this class and subclasses */
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private OfficeManager officeManager;

	// @RequestMapping(value = "/office.htm")
	// public ModelAndView handleRequest(HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException {
	// // String now = (new Date()).toString();
	// //logger.info("Returning office view with " + now);
	//
	// Map<String, Object> myModel = new HashMap<String, Object>();
	// //myModel.put("now", now);
	// myModel.put("office", this.officeManager.getOffices());
	//
	// return new ModelAndView("office", "model", myModel);
	// }

	// @RequestMapping(method = RequestMethod.POST)
	// public ModelAndView onSubmit(@Valid Searcher searcher, BindingResult
	// result)
	// throws OfficeNotFoundException {
	// // if (result.hasErrors()) {
	// // return "searcher";
	// // }
	//
	// String id = searcher.getId();
	// logger.info("Search office with id " + id + ".");
	//
	// // this.officeManager.searchOffice(id);
	//
	// Map<String, Object> myModel = new HashMap<String, Object>();
	//
	// myModel.put("office", this.officeManager.searchOffice(id));
	//
	// return new ModelAndView("office", "model", myModel);
	// // return "redirect:/hello.htm";
	// }

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView onSubmit(@Valid Searcher searcher, BindingResult result)
			throws OfficeNotFoundException {
		// if (result.hasErrors()) {
		// return "searcher";
		// }

		String id = searcher.getId();
		logger.info("Search office with id " + id + ".");

		// this.officeManager.searchOffice(id);

		// Map<String, Object> myModel = new HashMap<String, Object>();

		// myModel.put("office", this.officeManager.searchOffice(id));
		
		Office office = this.officeManager.searchOffice(id);
		if (office != null) {
			return new ModelAndView("office", "office", office);
		} else {
			return new ModelAndView("hello", "offices",
					this.officeManager.getOffices());
		}
		// return "redirect:/hello.htm";
	}

	// No
	// @RequestMapping(value = "/office.htm")
	// public ModelAndView handleRequest(@Valid Searcher searcher,
	// HttpServletRequest request,
	// HttpServletResponse response) throws ServletException, IOException,
	// OfficeNotFoundException {
	//
	// String now = (new Date()).toString();
	// logger.info("Returning office view with " + now);
	//
	// String id = searcher.getId();
	//
	// Map<String, Object> myModel = new HashMap<String, Object>();
	// myModel.put("now", now);
	// myModel.put("office", this.officeManager.searchOffice(id));
	//
	// return new ModelAndView("office", "model", myModel);
	// }

	@RequestMapping(method = RequestMethod.GET)
	protected Searcher formBackingObject(HttpServletRequest request)
			throws ServletException {
		Searcher searcher = new Searcher();
		searcher.setId("0000");
		return searcher;
	}

	public void setProductManager(OfficeManager officeManager) {
		this.officeManager = officeManager;
	}

	public OfficeManager getProductManager() {
		return officeManager;
	}
}
