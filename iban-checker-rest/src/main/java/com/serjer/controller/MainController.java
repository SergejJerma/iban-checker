package com.serjer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.serjer.domain.Iban;
import com.serjer.repo.IbanRepository;


@RestController
public class MainController {
	
	@Autowired
	private IbanRepository ibanRepository;
	
	@PostMapping(value = "check")
    public List<Iban> checkList(@RequestBody List<Iban> ibans) {
        return ibanRepository.checkListOfIbans(ibans);
    }

}
