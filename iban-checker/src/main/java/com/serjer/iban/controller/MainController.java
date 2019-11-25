package com.serjer.iban.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.serjer.iban.repo.IbanRepository;
import com.serjer.iban.service.IbanService;



@Controller
public class MainController {
	@Autowired
	private IbanService ibanService;
	
	@Autowired
	private IbanRepository ibanRepository;
	
	   @GetMapping("/")
	    public String greeting(Model model) {
	        return "greeting";
	    }
	   
	   @GetMapping("/single")
	    public String single(Model model) {	  
		   	return "single";
	    }
	   
	   @PostMapping("/single")
	    public String checkSingle(@RequestParam String ibanToCheck, Model model) {  
		   
		   model.addAttribute("iban", ibanToCheck);
		   if(ibanService.isValidIban(ibanToCheck)) 
			   model.addAttribute("message", "is valid.");
		   else
			   model.addAttribute("message", "is invalid.");
		   	return "result";
	    }
	   
	   
	   @GetMapping("/list")
	    public String checkList(Model model) {
		   return "list";
	    }
	   
	   @PostMapping("/list")
	    public String checkSingle(@RequestParam String filePath, @RequestParam String fileName, Model model) {  
		   if (ibanRepository.fileReading(filePath, fileName)) {
			   ibanRepository.fileWriting(filePath, fileName);
			   model.addAttribute("message", "The results are saved in the "
			   		+ "path you specified in the "+fileName +".out file.");
		   } else 
			   model.addAttribute("message", "Problems reading the file, "
			   		+ "please, check the path you entered and the file name and try again.");
		  	   
		   return "result";
	    }
}
