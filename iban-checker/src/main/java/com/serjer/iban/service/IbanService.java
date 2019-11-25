package com.serjer.iban.service;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.springframework.stereotype.Service;


@Service
public class IbanService {
	

	public boolean isValidIban(String iban) {
		String ibanToCheck = iban.replaceAll("\\s+", ""); //removing blanks if exists
		return isValidIbanLength(ibanToCheck)&&
			   isValidIbanCountryCode(ibanToCheck)&&
			   isValidIbanByMod97(ibanToCheck);
	}

	public boolean isValidIbanLength(String ibanToCheck) {
		return ibanToCheck.length()>4 && 
			   ibanToCheck.length()<35;
	}
	
	public boolean isValidIbanCountryCode(String ibanToCheck) {
		final List<String> countryCodes = Arrays.asList(Locale.getISOCountries());
		String countryCode = ibanToCheck.substring(0, 2).toUpperCase();
		return countryCodes.contains(countryCode);
	}
	
	public boolean isValidIbanByMod97(String ibanToCheck) {
		String modifiedIban = ibanToCheck.substring(4) + ibanToCheck.substring(0, 4);
		BigInteger checkNum = new BigInteger(modifiedIban.chars()
					.map(e -> e = Character.getNumericValue(e))
					.mapToObj(String::valueOf)
					.reduce((a, b) -> a.concat(b))
					.get());
		BigInteger mod = checkNum.mod(BigInteger.valueOf(97));
		return mod.intValue() == 1;
	}

}
