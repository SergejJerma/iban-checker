package com.serjer.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Iban {
private String iban;
private boolean isValid;

public Iban() {
	super();
}

public String getIban() {
	return iban;
}
public void setIban(String iban) {
	this.iban = iban;
}
public boolean isValid() {
	return isValid;
}
public void setValid(boolean isValid) {
	this.isValid = isValid;
}

}
