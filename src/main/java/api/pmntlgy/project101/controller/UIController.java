package api.pmntlgy.project101.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import api.pmntlgy.project101.model.Model1;
import api.pmntlgy.project101.model.Model2;
import api.pmntlgy.project101.service.Model1Service;
import api.pmntlgy.project101.service.Model2Service;

@Controller
public class UIController {
	Logger logger = Logger.getLogger(UIController.class.getName());
	@Autowired
	Model1Service model1Service;

	@Autowired
	Model2Service model2Service;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showWelcomePage(ModelMap model) {
		return "welcome";
	}

	@RequestMapping(value = "/recon", method = RequestMethod.GET)
	public String showReconciliationPage1(ModelMap model, Model1 model1, Model2 model2) {

		return "reconciliation";
	}

	@RequestMapping(value = "/recon", method = RequestMethod.POST/*, consumes = { MediaType.MULTIPART_FORM_DATA_VALUE }*/)
	public String showReconciliationPage2(ModelMap model, @RequestParam String filename1,
			@RequestParam String filename2/*, @RequestParam("filename1") MultipartFile file1,
			@RequestParam("filename2") MultipartFile file2*/) throws IllegalStateException, IOException {

		model.put("filename1", filename1);
		model.put("filename2", filename2);
		model.put("record1", model1Service.count());
		model.put("record2", model2Service.count());
		model.put("matched1", model1Service.getMatched());
		model.put("matched2", model2Service.getMatched());
		model.put("unmatched1", model1Service.getUnMatched());
		model.put("unmatched2", model2Service.getUnMatched());
		model.put("duplicate1", model1Service.getDuplicate());
		model.put("duplicate2", model2Service.getDuplicate());
		//file1.transferTo(new File("C:\\Users\\TEDDY\\Desktop\\Paymentology\\project\\files\\tmp\\file1.csv"));
		//file2.transferTo(new File("C:\\Users\\TEDDY\\Desktop\\Paymentology\\project\\files\\tmp\\file2.csv"));
		return showComparisonPage1(model);
	}

	@RequestMapping(value = "/comp", method = RequestMethod.GET)
	public String showComparisonPage1(ModelMap model) {
		return "comparison";
	}

	@RequestMapping(value = "/comp", method = RequestMethod.POST)
	public String showComparisonPage2(ModelMap model) {

		model.put("unmatched1", model1Service.getUnMatchedTransactions());
		model.put("unmatched2", model2Service.getUnMatchedTransactions());
		return showUnmatchedPage(model);
	}

	@RequestMapping(value = "/comp1", method = RequestMethod.POST)
	public String showComparisonPage3(ModelMap model) {
		// model.put("message", "Hi....");
		model.put("duplicated1", model1Service.getDuplicateRecords());
		model.put("duplicated2", model2Service.getDuplicateRecords());
		return showduplicatedPage(model);
	}

	@RequestMapping(value = "/unmatched", method = RequestMethod.GET)
	public String showUnmatchedPage(ModelMap model) {
		return "unmatched";
	}

	@RequestMapping(value = "/duplicated", method = RequestMethod.GET)
	public String showduplicatedPage(ModelMap model) {
		return "duplicated";
	}

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String showAboutPage() {
		return "about";

	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String LoginPage(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage2(ModelMap model, @RequestParam String name) {
		model.put("name", name);
		return this.showWelcomePage(model);
	}

}
