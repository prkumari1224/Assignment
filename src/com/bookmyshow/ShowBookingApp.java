package com.bookmyshow;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShowBookingApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BookingSystem bookingSystem = new BookingSystem();
		System.out.println("Admin/Buyer:");
		String userCommand = scanner.nextLine();
		String[] user = userCommand.split(" ");
		while (user[0].equalsIgnoreCase("buyer") || user[0].equalsIgnoreCase("admin")) {
			if (user[0].equalsIgnoreCase("admin")) {
				System.out.println("Enter Command: ");
				String command = scanner.nextLine();
				String[] tokens = command.split(" ");
				String action = tokens[0];
				if (action.equalsIgnoreCase("Setup")) {
					if (!validateParameterCount(tokens, 4)) {
						System.out.println(
								"Some parameters are missing, Please enter all details in this format: Setup <Show Number> <Number of Rows> <Number of Seats per Row> <Cancellation Window in Minutes>");
					} else if (!validateParameterType(tokens)) {
						System.out.println("Incorrect input format");
					} else {
						int showNumber = Integer.parseInt(tokens[1]);
						int numRows = Integer.parseInt(tokens[2]);
						int seatsPerRow = Integer.parseInt(tokens[3]);
						int cancellationWindow = Integer.parseInt(tokens[4]);
						bookingSystem.setupShow(showNumber, numRows, seatsPerRow, cancellationWindow);

					}
					// System.out.println("Show set up successfully.");
				} else if (action.equalsIgnoreCase("View")) {
					int showNumber;
					if (!validateParameterCount(tokens, 1)) {
						System.out.println(
								"Some parameters are missing, Please enter all details in this format: View <Show Number>");
					} else if (!validateParameterType(tokens)) {
						System.out.println("Incorrect input format");
					} else {
						showNumber = Integer.parseInt(tokens[1]);
						bookingSystem.viewShow(showNumber);
					}
				} else if (action.equalsIgnoreCase("q")) {
					// System.exit(1);
					System.out.println("Admin/Buyer");
					userCommand = scanner.nextLine();
					user = userCommand.split(" ");
				} else {
					System.out.println("Invalid command.");
				}
			} else if (user[0].equalsIgnoreCase("buyer")) {
				System.out.println("Enter Command: ");
				String command = scanner.nextLine();
				String[] tokens = command.split(" ");
				String action = tokens[0];
				if (action.equalsIgnoreCase("Availability")) {
					if (!validateParameterCount(tokens, 1)) {
						System.out.println(
								"Some parameters are missing, Please enter all details in this format: Availability <ShowNumber>");
					} else if (!validateParameterType(tokens)) {
						System.out.println("Incorrect show number format");
					} else {
						int showNumber = Integer.parseInt(tokens[1]);
						bookingSystem.listAvailableSeats(showNumber);
					}
				} else if (action.equalsIgnoreCase("Book")) {
					if (!validateParameterCount(tokens, 3)) {
						System.out.println(
								"Some parameters are missing, Please enter all details in this format: Availability <ShowNumber>");
					}
					else {
						int showNumber = Integer.parseInt(tokens[1]);
						String phoneNumber = tokens[2];
						List<String> seats = Arrays.asList(tokens[3].split(","));
						bookingSystem.bookTicket(showNumber, phoneNumber, seats);
					}
				} else if (action.equalsIgnoreCase("Cancel")) {
					if (!validateParameterCount(tokens, 3)) {
						System.out.println(
								"Some parameters are missing, Please enter all details in this format: Availability <ShowNumber>");
					} else {
						String ticketNumber = tokens[1];
						String phoneNumber = tokens[2];
						bookingSystem.cancelTicket(ticketNumber, phoneNumber);
					}
				} else if (action.equalsIgnoreCase("q")) {
					System.out.println("Admin/Buyer");
					userCommand = scanner.nextLine();
					user = userCommand.split(" ");
				} else {
					System.out.println("Invalid command.");
				}
			}
		}

	}

	private static boolean validateParameterType(String[] tokens) {
		try {
			for (int i =1 ; i< tokens.length;i++) {
				Integer.parseInt(tokens[i]);
			}
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private static boolean validateParameterCount(String[] tokens, int count) {
		if (tokens.length-1 != count) {
			return false;
		} else {
			return true;
		}
	}
}
