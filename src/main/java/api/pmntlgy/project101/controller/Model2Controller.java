package api.pmntlgy.project101.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.pmntlgy.project101.model.Model1;
import api.pmntlgy.project101.model.Model2;
import api.pmntlgy.project101.service.Model1Service;
import api.pmntlgy.project101.service.Model2Service;

@RestController
public class Model2Controller {

	@Autowired
	Model2Service model2Service;

	@GetMapping("/file2")
	Iterable<Model2> retrieve() {
		// if (model1Service.count() != 0)
		return model2Service.findAll();
	}

	@GetMapping("/file2/{id}")
	Optional<Model2> retrieveById(@PathVariable long id) {
		Optional<Model2> trxn = model2Service.findById(id);
		return trxn;

	}

	@PostMapping("/file2/upload/{path}")
	public void loadFile(@PathVariable String path) {
		path = "C:/Users/TEDDY/Desktop/Paymentology/project/files/PaymentologyMarkoffFile20140113.csv";
		// path = "/opt/tmp/files/file1.csv"; // linux
		path = "C:/Users/TEDDY/Desktop/Paymentology/project/files/tmp/file2.csv";
		model2Service.loadFile(path);
	}

	@GetMapping("/file2/matched-list")
	public List<Model2> retrieveMatched() {
		List<Model2> records = model2Service.getMatchedTransactions();
		return records;
	}

	@GetMapping("/file2/matched")
	public int countMatched() {
		return model2Service.getMatched();
	}

	@GetMapping("/file2/unmatched-list")
	public List<Model2> retrieveUnMatched() {
		List<Model2> records = model2Service.getUnMatchedTransactions();
		return records;
	}

	@GetMapping("/file2/unmatched")
	public int countUnMatched() {
		return model2Service.getUnMatched();
	}

	@GetMapping("/file2/total")
	public long countRecords() {
		return model2Service.count();
	}

}
