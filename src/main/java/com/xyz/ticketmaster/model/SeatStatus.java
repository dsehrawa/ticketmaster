package com.xyz.ticketmaster.model;

public enum SeatStatus {
    FREE(0),
    RESERVED(1),
    BOOKED(2);

    private int value;

    SeatStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
