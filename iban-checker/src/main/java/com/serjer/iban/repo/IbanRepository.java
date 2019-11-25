package com.serjer.iban.repo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serjer.iban.domain.Iban;
import com.serjer.iban.service.IbanService;

@Component
public class IbanRepository {
	private final static List<Iban> ibanList = new ArrayList<>();
	
	@Autowired
	private IbanService ibanService;
	
	public boolean fileReading(String path, String fileName) {
		try {
			Scanner scanner = new Scanner(new File(path + fileName));
			while (scanner.hasNextLine()) {
				String ibanFromFile = scanner.nextLine();
				ibanList.add(new Iban(ibanFromFile, ibanService.isValidIban(ibanFromFile)));
			}
			scanner.close();
			return true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean fileWriting(String path, String fileName) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path + fileName + ".out"));
			ibanList.stream().forEach(e -> {
				try {
					writer.write(e.toString());
					writer.write(System.getProperty("line.separator"));
				} catch (IOException e1) {
					e1.printStackTrace();
					}
			});
			writer.close();
			ibanList.clear();
			return true;
		} catch (IOException e2) {
			e2.printStackTrace();
			return false;
		}
	}

}
