package com.addressbook.test;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.addressbook.data.Address;
import com.addressbook.data.Person;
import com.addressbook.main.ContactSearchImpl;
import com.addressbook.utilities.CSVConverter;

public class AddressBookTest {
	private static String fileName = "";
	private static List<String> rows;
	private static List<Person> contact;
	private ContactSearchImpl contactSearchImpl = new ContactSearchImpl();
	@BeforeClass
	public static void csvToPojoConverter() throws IOException{
	fileName = "csvFileTest.csv";
	rows = getCSVRows(fileName);
	contact = CSVConverter.convertToPersonObj(rows);
	}
	@Test
	public void testResultNotFound() throws IOException{
	//	String fileName = "csvFile.csv";
		List<Person> newContact = contactSearchImpl.searchContactFromAddressBook("Jon", contact);
		Assert.assertTrue(newContact.isEmpty());
		
	}
	
	@Test
	public void testResultFound() throws IOException{
		List<Person> newContact = contactSearchImpl.searchContactFromAddressBook("Dave", contact);
		Assert.assertFalse(newContact.isEmpty());
	}
	
	@Test
	public void testMultipleMatchFound() throws IOException{
		List<Person> newContact = contactSearchImpl.searchContactFromAddressBook("Jane", contact);
		Assert.assertFalse(newContact.isEmpty());
	}
	
	@Test
	public void testValidInputWithLastName() throws IOException{
		List<Person> newContact = contactSearchImpl.searchContactFromAddressBook("Smith", contact);
		Assert.assertFalse(newContact.isEmpty());
	}
	
	@Test
	public void testValidInputWithAge() throws IOException{
		List<Person> newContact = contactSearchImpl.searchContactFromAddressBook("13", contact);
		Assert.assertFalse(newContact.isEmpty());
	}
	
	@Test
	public void testValidInputWithCity() throws IOException{
		Address address = new Address();
		address.setStreet("123 Main St.");
		address.setCity("Seattle");
		address.setCountry("WA");
		List<Person> newContact = contactSearchImpl.searchContactFromAddressBook(address.getCity(), contact);
		Assert.assertFalse(newContact.isEmpty());
	}
	
	@Test
	public void testValidInputWithStreet() throws IOException{
		Address address = new Address();
		address.setStreet("123 Main St.");
		address.setCity("Seattle");
		address.setCountry("WA");
		List<Person> newContact = contactSearchImpl.searchContactFromAddressBook(address.getStreet(), contact);
		Assert.assertFalse(newContact.isEmpty());
	}
	
	@Test
	public void testValidInputWithCountry() throws IOException{
		Address address = new Address();
		address.setStreet("123 Main St.");
		address.setCity("Seattle");
		address.setCountry("WA");
		List<Person> newContact = contactSearchImpl.searchContactFromAddressBook(address.getCountry(), contact);
		Assert.assertFalse(newContact.isEmpty());
	}

	public static List<String> getCSVRows(String fileName) throws IOException {
		InputStream stream = AddressBookTest.class.getClassLoader().getResourceAsStream(fileName);
		InputStreamReader streamReader = new InputStreamReader(stream);
		List<String> listOfRows = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(streamReader);) {
			String row = "";
			while ((row = br.readLine()) != null) {
				listOfRows.add(row);
			}
		}
		return listOfRows;
	}

}
