package com.serjer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.serjer.iban.service.IbanService;



@SpringBootTest
class UserServiceTests {
	@Autowired
	private IbanService ibanService;

		
	@Test
    public void testIsValidIbanLength() {
		assertTrue(ibanService.isValidIbanLength("12345"));
        assertFalse(ibanService.isValidIbanLength("1234"));
        assertFalse(ibanService.isValidIbanLength("12345678912345678912345678912345678"));
    }
	
	@Test
    public void testIsValidIbanCountryCode() {
		assertTrue(ibanService.isValidIbanCountryCode("LT"));
		assertTrue(ibanService.isValidIbanCountryCode("lv"));
        assertFalse(ibanService.isValidIbanCountryCode("12"));
        assertFalse(ibanService.isValidIbanCountryCode("ww"));
    }
	
	@Test
    public void testIsValidIbanByMod97() {
		assertTrue(ibanService.isValidIbanByMod97("5233155039"));
        assertTrue(ibanService.isValidIbanByMod97("30001550395"));
        assertFalse(ibanService.isValidIbanByMod97("56749607975"));
        assertFalse(ibanService.isValidIbanByMod97("3575860403837"));
    }
	
	@Test
    public void testIsValidIban() {
		assertTrue(ibanService.isValidIban("LT02 7300 0101 5573 0125"));
        assertTrue(ibanService.isValidIban("GT20AGRO00000000001234567890"));
        assertTrue(ibanService.isValidIban("AZ96AZEJ00000000001234567890"));
        assertTrue(ibanService.isValidIban("BR1500000000000010932840814P2"));
		assertFalse(ibanService.isValidIban("DO25 ACAU 0000 0000 0001 2345 6789"));
		assertFalse(ibanService.isValidIban("KV43ACAT00000000000000123123"));
		assertFalse(ibanService.isValidIban("FR7630006000011234567890186"));
		assertFalse(ibanService.isValidIban("HU93116000060000000012345677"));
        
    }
	
}
