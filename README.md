# Addressbook
 Maven project to search for a contact in addressbook(in csv) and return matching contacts if any.

# What does this application do?
Using this application you can search for a contact in a given address book by:
1. First name
2. Last name
3. Address(search by either street name, city or country)
4. Age

# How to setup?
You can download the latest release of the project from releases page and start using it right away.

# How to run?

You can use the java -jar command from cmd prompt and run the jar, the jar file takes 2 parameters:

1. Addressbook name in csv format (example: addressbook.csv)
2. Search string

*java -jar *(path to jar)*/AddressBook.jar (csv_file_name.csv) *(Search String)**
and simply enter the search string to view the search results.

Note:- You need to add your own csv(Address Book), also make sure to place the csv and jar in same folder.

CSV Format to be followed: "Dave","Smith","123 main st.","seattle","wa","43"

