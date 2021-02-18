package com.addressbook.main;

import java.io.IOException;
import java.util.List;

import com.addressbook.data.Person;
import com.addressbook.utilities.CSVConverter;

public class AddressBook {

	public static void main(String[] args) throws IOException {
		String searchString = args[1];
		String fileName = args[0];
		List<String> contactDetailsFromCsv = CSVConverter.getCSVRows(fileName);
		List<Person> contactDetails = CSVConverter.convertToPersonObj(contactDetailsFromCsv);
		ContactSearchImpl contactSearchImpl = new ContactSearchImpl();
		List<Person> listOfContact = contactSearchImpl.searchContactFromAddressBook(searchString, contactDetails);
		if (!listOfContact.isEmpty()) {
			for (Person contact : listOfContact) {
				System.out.println("Contact Found:----  " + contact.getName() + ", " + contact.getLastname() + ", "
						+ contact.getAddress() + " "+ contact.getAge());
			}
		} else {
			System.out.println("No Contact found");
		}

	}

}
