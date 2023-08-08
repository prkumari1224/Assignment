package com.bookmyshow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BookingSystem {
	Map<Integer, Show> shows;
    Map<String, String> bookedTickets;

    BookingSystem() {
        shows = new HashMap<>();
        bookedTickets = new HashMap<>();
    }

    void setupShow(int showNumber, int numRows, int seatsPerRow, int cancellationWindow) {
    	if(numRows <=10 && seatsPerRow <=26) {
	        Show show = new Show(showNumber, numRows, seatsPerRow, cancellationWindow);
	        shows.put(showNumber, show);
	        System.out.println("Show set up successfully.");
    	}
    	else {
    		System.out.println("Invalid row or seat");
    		//System.exit(1);
    	}
    }
    
    Show getShow(int showNumber) {
    	return shows.get(showNumber);
    }

    void viewShow(int showNumber) {
        Show show = shows.get(showNumber);
        if (show != null) {
            System.out.println("Show Number: " + show.showNumber);
            bookedTickets.entrySet().stream().filter(entry -> entry.getValue().equals(Integer.toString(showNumber))).forEach(entry -> {
                String ticketNumber = entry.getKey();
                if(!bookedTickets.containsKey(ticketNumber)) {
                	System.out.println("No tickets booked for this show yet");
                }
                String buyerPhone = ticketNumber.substring(0, 10);
                String seatNumbers = ticketNumber.substring(10);
                System.out.println("Ticket#: " + ticketNumber + ", Buyer Phone#: " + buyerPhone + ", Seat Numbers: " + seatNumbers);
            });
        } else {
            System.out.println("Show not found.");
        }
    }

    void listAvailableSeats(int showNumber) {
        Show show = shows.get(showNumber);
        if (show != null) {
            System.out.println("Available seats for Show " + showNumber + ":");
            show.availableSeats.forEach((seat)-> System.out.println(seat + " "));
            System.out.println();
        } else {
            System.out.println("Show not found.");
        }
    }

    void bookTicket(int showNumber, String phoneNumber, List<String> seats) {
        Show show = shows.get(showNumber);
        if (show != null && !isTicketAlreadyBooked(phoneNumber,showNumber)) {
        	List<String> unavailableSeats = new ArrayList<>();
        	for (String seat : seats) {
                if (!show.availableSeats.contains(seat)) {
                    System.out.println("Seat " + seat + " is not available.");
                    return;
                }
                unavailableSeats.add(seat);
            }
            String ticketNumber = phoneNumber + String.join("", seats);
            for (String seat : unavailableSeats) {
                show.availableSeats.remove(seat);
            }
            bookedTickets.put(ticketNumber, Integer.toString(showNumber));
            System.out.println("Ticket booked successfully. Ticket#: " + ticketNumber);
		} else if (show == null) {
                System.out.println("Show not found.");
            }
    }

    void cancelTicket(String ticketNumber, String phoneNumber) {
        if (bookedTickets.containsKey(ticketNumber) && phoneNumber.equals(ticketNumber.substring(0, 10))) {
            String showNumber = bookedTickets.get(ticketNumber);
            bookedTickets.remove(ticketNumber);
            Show show = shows.get(Integer.parseInt(showNumber));
            String seats = ticketNumber.substring(10);
            for (int i = 0; i < seats.length(); i += 2) {
                String seat = seats.substring(i, i + 2);
                show.availableSeats.add(seat);
            }
            System.out.println("Ticket cancelled successfully.");
        } else {
            System.out.println("Ticket not found or does not match phone number.");
        }
    }
    
    boolean isTicketAlreadyBooked(String phoneNumber, int showNumber) {
    	//Set<String> tickets = bookedTickets.keySet();
    	for(Map.Entry<String,String> entry : bookedTickets.entrySet()) {
    		if(entry.getKey().substring(0,10).equals(phoneNumber) && showNumber==Integer.parseInt(entry.getValue())) {
    			System.out.println("Ticket already booked");
    			return true;
    		}
    	}
    	return false;
    }
}
