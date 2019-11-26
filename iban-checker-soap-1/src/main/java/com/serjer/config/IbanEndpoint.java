package com.serjer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.serjer.iban.IbansRequest;
import com.serjer.iban.IbansResponse;
import com.serjer.repo.IbanRepository;



@Endpoint
public class IbanEndpoint {
	private static final String NAMESPACE_URI = "http://serjer.com/iban";
	
	
	@Autowired
	private IbanRepository ibanRepository;


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "IbansRequest")
	@ResponsePayload
	public IbansResponse getCountry(@RequestPayload IbansRequest request) {
		IbansResponse response = new IbansResponse();

		response.getIbans().addAll(ibanRepository.checkListOfIbans(request.getIbans()));
			
		return response;
	}
	
}	