package es.unileon.ulebank.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.service.Bank;

public class OfficesControllerTests {

	@Test
	public void testHandleRequestView() throws Exception {
		OfficesController controller = new OfficesController();
		controller.setOfficeManager(new Bank("0123"));
		ModelAndView modelAndView = controller.handleRequest(null, null);
		assertEquals("hello", modelAndView.getViewName());
		assertNotNull(modelAndView.getModel());
		@SuppressWarnings("unchecked")
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView
				.getModel().get("model");
		String nowValue = (String) modelMap.get("now");
		assertNotNull(nowValue);

	}

}