package com.xyz.ticketmaster.model;

public enum OnBoardingStrategy {
    RESERVED(1),
    NON_RESERVED(2);

    private int value;

    OnBoardingStrategy(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
