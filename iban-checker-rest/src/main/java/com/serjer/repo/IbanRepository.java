package com.serjer.repo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serjer.domain.Iban;
import com.serjer.service.IbanService;


@Component
public class IbanRepository {
	private final static List<Iban> chekedIbans = new ArrayList<>();
	
	@Autowired
	private IbanService ibanService;
	
	public List<Iban> checkListOfIbans(List<Iban> ibans) {
        ibans.stream().forEach(i -> {
        	if(ibanService.isValidIban(i.getIban())) {
        		i.setValid(true);
        		chekedIbans.add(i);
        	} else {
        		i.setValid(false);
        		chekedIbans.add(i);
        	}
        });
        return chekedIbans;
    }

	

}
