package es.unileon.ulebank.web;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.exceptions.OfficeNotFoundException;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.service.OfficeManager;
import es.unileon.ulebank.service.Searcher;

@Controller
public class InformationController {


	
	protected final Log logger = LogFactory.getLog(getClass());

	@Autowired
	private OfficeManager officeManager;

	@RequestMapping(value = "/office.htm")
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String now = (new Date()).toString();
		logger.info("Returning hello view with " + now);

		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("now", now);
		myModel.put("office", this.officeManager.getOffices());

		return new ModelAndView("office", "model", myModel);
	}

	public void setOfficeManager(OfficeManager officeManager) {
		this.officeManager = officeManager;
	}
	
	
}
