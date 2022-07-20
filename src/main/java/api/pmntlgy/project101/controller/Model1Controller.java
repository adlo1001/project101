package api.pmntlgy.project101.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import api.pmntlgy.project101.model.Model1;
import api.pmntlgy.project101.service.Model1Service;

@RestController
public class Model1Controller {

	@Autowired
	Model1Service model1Service;

	@PostMapping("/file1/uploaddd")
	public void create() {
		Model1 model1 = new Model1();
		model1.setProfileName("test1000");
		model1.setTransactionDate(new Date());
		model1.setTransactionDescription("test1000");
		model1.setTransactionNarrative("test1000");
		model1.setTransactionAmount(1000);
		model1.setTransactionID("test1000");
		model1.setTransactionType('P');
		model1.setWallentReference("test1000");
		model1Service.save(model1);

	}

	@GetMapping("/file1")
	Iterable<Model1> retrieve() {
		// if (model1Service.count() != 0)
		return model1Service.findAll();
	}

	@GetMapping("/file1/{id}")
	Optional<Model1> retrieveById(@PathVariable long id) {
		Optional<Model1> trxn = model1Service.findById(id);
		return trxn;

	}

	@PostMapping("/file1/upload/{path}")
	public void loadFile1(@PathVariable String path) {
		path = "C:/Users/TEDDY/Desktop/Paymentology/project/files/ClientMarkoffFile20140113.csv";
		//path = "/opt/tmp/files/file1.csv"; // linux
		path = "C:/Users/TEDDY/Desktop/Paymentology/project/files/tmp/file1.csv";
		model1Service.loadFile(path);
	}

	@GetMapping("/file1/matched-list")
	public List<Model1> retrieveMatched() {
		List<Model1> records = model1Service.getMatchedTransactions();
		return records;
	}

	@GetMapping("/file1/matched")
	public int countMatched() {
		return model1Service.getMatched();
	}

	@GetMapping("/file1/unmatched-list")
	public List<Model1> retrieveUnMatched() {
		List<Model1> records = model1Service.getUnMatchedTransactions();
		return records;
	}

	@GetMapping("/file1/unmatched")
	public int countUnMatched() {
		return model1Service.getUnMatched();
	}

	@GetMapping("/file1/unmatchedIds")
	public List<String> UnMatched() {
		return model1Service.getUnMatchedList();
	}

	@GetMapping("/file1/total")
	public long countRecords() {
		return model1Service.count();
	}

}
