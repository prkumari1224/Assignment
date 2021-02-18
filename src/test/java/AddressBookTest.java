import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.addressbook.main.Address;
import com.addressbook.main.AddressBook;
import com.addressbook.main.Person;

public class AddressBookTest {
	AddressBook addressBook = new AddressBook();
	
//	@Test
//	public void testEmptyFile(){
//		
//	}
//	
//	@Test
//	public void testFileNotFound(){
//		
//	}
	
	@Test
	public void testInvalidInput() throws IOException{
//		
//		Address address = new Address();
//		address.setStreet("123 main st.");
//		address.setCity("seattle");
//		address.setCountry("wa");
//		Person contact = new Person("Dave", "Smith", address, 43);
		String fileName = "csvFile.csv";
		List<Person> newContact = addressBook.searchPerson("Dave", fileName);
	//	Assert.assertEquals(contact.getName(), newContact.get(0));
		
	}
	
//	@Test
//	public void testValidInput(){
//		
//	}
//	
//	@Test
//	public void testValidInputWithName(){
//		
//	}
//	
//	@Test
//	public void testValidInputWithLastName(){
//		
//	}
//	
//	@Test
//	public void testValidInputWithAge(){
//		
//	}
//	
//	@Test
//	public void testValidInputWithAddress(){
//		
//	}
//	
//	@Test
//	public void testNumberFormatException(){
//		
//	}
	
	public List<Person> readCsv(String fileName) throws IOException{
		InputStream stream = AddressBookTest.class.getClassLoader().getResourceAsStream(fileName);
		InputStreamReader streamReader = new InputStreamReader(stream);
		List<Person> person = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(streamReader);) {
			String row = "";
			while ((row = br.readLine()) != null) {
				row = row.replace("\"", "");
				String[] personArray = row.split(",");
		//		Person per = getPersonDetail(personArray);
		//		person.add(per);
			}
		}
		return person;
	}
}
