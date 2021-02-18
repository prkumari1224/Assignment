package com.addressbook.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AddressBook {

	public static void main(String[] args) throws IOException {
		AddressBook book = new AddressBook();
		String fileName = "csvFile.csv";
		book.searchPerson("seattle", fileName);

	}

	public List<Person> searchPerson(String searchString, String fileName) throws IOException {

		List<Person> contactDetails = csvToPojoConversion(fileName);
		List<Person> searchResult = new ArrayList<>();
		for (Person contact : contactDetails) {
			if (contact.getName().equals(searchString)) {
				searchResult.add(contact);
			} else if (contact.getLastname().equals(searchString)) {
				searchResult.add(contact);
			} else if (contact.getAge() == Integer.parseInt(searchString)) {
				searchResult.add(contact);
			} else {
				searchAddress(contact, searchString, searchResult);
			}
		}

		return searchResult;
	}

	private void searchAddress(Person contact, String searchString, List<Person> searchResult) {
		if (searchString.equals(contact.getAddress().getCity()) || searchString.equals(contact.getAddress().getStreet())
				|| searchString.equals(contact.getAddress().getCountry())) {
			searchResult.add(contact);
		}
	}

	public List<Person> csvToPojoConversion(String fileName) throws IOException {
		InputStream stream = AddressBook.class.getClassLoader().getResourceAsStream(fileName);
		InputStreamReader streamReader = new InputStreamReader(stream);
		List<Person> person = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(streamReader);) {
			String row = "";
			while ((row = br.readLine()) != null) {
				row = row.replace("\"", "");
				String[] personArray = row.split(",");
				Person per = getPersonDetail(personArray);
				person.add(per);
			}
		}
		return person;
	}

	private Person getPersonDetail(String[] personArray) {
		Address address = new Address();
		address.setStreet(personArray[2]);
		address.setCity(personArray[3]);
		address.setCountry(personArray[4]);
		Person person = new Person(personArray[0], personArray[1], address, Integer.parseInt(personArray[5]));
		return person;
	}
	
	public List<Person> 

}
