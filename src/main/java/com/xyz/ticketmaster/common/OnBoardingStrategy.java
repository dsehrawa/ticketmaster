package com.xyz.ticketmaster.common;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;
import java.util.Map;

public enum OnBoardingStrategy {
    RESERVED(1),
    NON_RESERVED(2);

    private int value;
    private final static Map<Integer, OnBoardingStrategy> CONSTANTS = new HashMap<>();

    static {
        for (OnBoardingStrategy c : values()) {
            CONSTANTS.put(c.value, c);
        }
    }

    OnBoardingStrategy(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static OnBoardingStrategy fromValue(int value) {
        OnBoardingStrategy constant = CONSTANTS.get(value);
        if (constant == null) {
            throw new IllegalArgumentException();
        } else {
            return constant;
        }
    }
}
