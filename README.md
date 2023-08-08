
#Show Booking Application
This is a simple Java application that allows users to book and manage tickets for different shows. The application supports two types of users: Admin and Buyer.

Features:-

1. Admin -
	Admin users can perform the following actions:

		a. Set up shows with the number of available seats per show.
		b. View the list of shows and seat allocations.
		
		Commands for Admin:-
		Setup <Show Number> <Number of Rows> <Number of Seats per Row> <Cancellation Window in Minutes>
			- Sets up the number of seats per show.
			
		View <Show Number>
			- Displays show information, including Ticket#, Buyer Phone#, and Seat Numbers allocated to the buyer.
		
		q
			- When admin is done with setup of show , he may want to exit and user will again be prompted for
			Admin/Buyer selection option.
2. Buyer -
	Buyer users can perform the following actions:

		a. Retrieve the list of available seats for a show.
		b. Select and book one or more seats.
		c. Cancel booked tickets.
		
		Commands for Buyer
		Availability <Show Number>
			- Lists all available seat numbers for a show (e.g., A1, F4, etc.).
		Book <Show Number> <Phone#> <Comma Separated List of Seats>
			- Books a ticket, generates a unique ticket #, and displays the booking information.
		Cancel <Ticket#> <Phone#>
			- Cancels a booked ticket and updates the available seats list.
		q
			- When buyer is done with performing the operations , he may want to exit and user will again be prompted for
			Admin/Buyer selection option.
			
Assumption:- Once user books the ticket then only ticket details will be shown to admin otherwise he can only see show number.
			
#How to Use
Run the .jar file from command prompt using command :- java -jar bookmyshow.jar

The application will prompt for user input. Enter Admin or Buyer to identify the type of user.

Depending on the user type, you can use the available commands to perform actions.

Example Usage
Admin
Setup 1 5 10 120

View show details: 
View 1

Buyer
Check seat availability: 
Availability 1

Book tickets: 
Book 1 1234567890 A1,A2

Cancel a ticket: 
Cancel 1234567890A1A2 1234567890

#Note
The program runs in the command-line interface (CLI).
Input is provided as space-separated commands.
Ticket numbers are generated based on the buyer's phone number and selected seats.
Ticket cancellation updates the list of available seats.

