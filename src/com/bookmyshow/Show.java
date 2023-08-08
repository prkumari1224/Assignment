package com.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class Show {
	int showNumber;
    int numRows;
    int seatsPerRow;
    int cancellationWindow;
    List<String> availableSeats;
    boolean isBooked;

    Show(int showNumber, int numRows, int seatsPerRow, int cancellationWindow) {
        this.showNumber = showNumber;
        this.numRows = numRows;
        this.seatsPerRow = seatsPerRow;
        this.cancellationWindow = cancellationWindow;
        this.availableSeats = new ArrayList<>();
        initializeSeats();
    }

    private void initializeSeats() {
        for (int i = 0; i < numRows; i++) {
            for (int j = 1; j <= seatsPerRow; j++) {
                availableSeats.add((char) ('A' + i) + Integer.toString(j));
            }
        }
    }

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}
}
