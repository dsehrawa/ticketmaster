package com.xyz.ticketmaster.common;

public enum BookingStatus {
    RESERVED(1),
    BOOKED(2);

    private int value;

    BookingStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
