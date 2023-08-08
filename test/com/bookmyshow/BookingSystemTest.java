package com.bookmyshow;

import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class BookingSystemTest {

    private BookingSystem bookingSystem;

    @BeforeAll
    public void setUp() {
        bookingSystem = new BookingSystem();
    }

    @Test
    void testSetupShow() {
        bookingSystem.setupShow(1, 5, 10, 120);
        assertNotNull(bookingSystem.shows.get(1));
    }

    @Test
    public void testSetupShowValidInput() {
        bookingSystem.setupShow(1, 5, 10, 120);
        assertTrue(bookingSystem.shows.containsKey(1));
    }

    @Test
    public void testSetupShowInvalidRowSeats() {
        bookingSystem.setupShow(2, 11, 26, 120);
        assertFalse(bookingSystem.shows.containsKey(2));
    }

    @Test
    public void testViewShow() {
        bookingSystem.setupShow(1, 5, 10, 120);
        bookingSystem.bookTicket(1, "1234567890", Arrays.asList("A1", "B2"));
        assertNotNull(bookingSystem.shows.get(1));
    }

    @Test
    public void testListAvailableSeats() {
        bookingSystem.setupShow(1, 5, 10, 120);
        bookingSystem.listAvailableSeats(1);
        // Add more assertions as needed
    }

    @Test
    public void testBookTicketValidInput() {
        bookingSystem.setupShow(1, 5, 10, 120);

        String initialAvailableSeats = bookingSystem.shows.get(1).availableSeats.toString();
        String initialBookedTickets = bookingSystem.bookedTickets.toString();

        // Book the tickets
        bookingSystem.bookTicket(1, "1234567890", Arrays.asList("A1", "A2"));

        String updatedAvailableSeats = bookingSystem.shows.get(1).availableSeats.toString();
        String updatedBookedTickets = bookingSystem.bookedTickets.toString();

        // Assert the changes
        assertNotEquals(initialAvailableSeats, updatedAvailableSeats);
        assertNotEquals(initialBookedTickets, updatedBookedTickets);

    }


    @Test
    public void testCancelTicketValidInput() {
      //  bookingSystem.setupShow(1, 5, 10, 120);

        // Book a ticket before canceling it
        bookingSystem.bookTicket(1, "1234567890", Arrays.asList("A1", "A2"));

        String initialAvailableSeats = bookingSystem.shows.get(1).availableSeats.toString();
        String initialBookedTickets = bookingSystem.bookedTickets.toString();

        // Cancel the booked ticket
        bookingSystem.cancelTicket("1234567890A1A2", "1234567890");

        String updatedAvailableSeats = bookingSystem.shows.get(1).availableSeats.toString();
        String updatedBookedTickets = bookingSystem.bookedTickets.toString();

        // Assert the changes
        assertNotEquals(initialAvailableSeats, updatedAvailableSeats);
        assertNotEquals(initialBookedTickets, updatedBookedTickets);

        // Assert that the specific booking has been canceled
        assertFalse(updatedBookedTickets.contains("1234567890A1A2"));
    }



//    @Test
//    public void testBookTicketInvalidInput() {
//        bookingSystem.setupShow(1, 5, 10, 120);
//        String initialAvailableSeats = bookingSystem.shows.get(1).availableSeats.toString();
//        String initialBookedTickets = bookingSystem.bookedTickets.toString();
//
//        bookingSystem.bookTicket(1, "1234567890", Arrays.asList("A1", "B2"));
//
//        String updatedAvailableSeats = bookingSystem.shows.get(1).availableSeats.toString();
//        String updatedBookedTickets = bookingSystem.bookedTickets.toString();
//
//        // Assert the changes
//        assertNotEquals(initialAvailableSeats, updatedAvailableSeats);
//        assertNotEquals(initialBookedTickets, updatedBookedTickets);
//    }

    @Test
    public void testCancelTicketInvalidInput() {
        String initialAvailableSeats = bookingSystem.shows.get(1).availableSeats.toString();
        String initialBookedTickets = bookingSystem.bookedTickets.toString();

        bookingSystem.cancelTicket("1234567890A1A2", "9876543210");

        String updatedAvailableSeats = bookingSystem.shows.get(1).availableSeats.toString();
        String updatedBookedTickets = bookingSystem.bookedTickets.toString();

        // Assert the changes
        assertEquals(initialAvailableSeats, updatedAvailableSeats);
        assertEquals(initialBookedTickets, updatedBookedTickets);
    }

    @Test
    public void testIsTicketAlreadyBooked() {
        bookingSystem.setupShow(1, 5, 10, 120);
        bookingSystem.bookTicket(1, "1234567890", Arrays.asList("A1", "B2"));
        assertTrue(bookingSystem.isTicketAlreadyBooked("1234567890", 1));
    }

    @Test
    public void testIsTicketNotAlreadyBooked() {
        bookingSystem.setupShow(1, 5, 10, 120);
        assertFalse(bookingSystem.isTicketAlreadyBooked("9876543210", 1));
    }
}
