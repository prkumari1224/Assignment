package com.bookmyshow;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ShowTest {

    private Show show;

    @BeforeAll
    public void setUp() {
        show = new Show(1, 5, 10, 120);
    }

    @Test
    public void testInitializeSeats() {
        assertEquals(50, show.availableSeats.size());
    }

}

