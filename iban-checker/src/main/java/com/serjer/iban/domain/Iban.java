package com.serjer.iban.domain;

public class Iban {
private String iban;
private boolean isValid;


public Iban() {
	super();
}
public Iban(String iban, boolean isValid) {
	super();
	this.iban = iban;
	this.isValid = isValid;
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
@Override
public String toString() {
	return iban + ";" + isValid;
}


}
