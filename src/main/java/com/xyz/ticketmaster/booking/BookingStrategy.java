package com.xyz.ticketmaster.booking;

import com.xyz.ticketmaster.exception.SeatNotAvailable;
import com.xyz.ticketmaster.common.OnBoardingStrategy;

import java.util.List;

public interface BookingStrategy {
    OnBoardingStrategy getType();
    void lockSeats(int showID, List<Integer> cinemaSeatIDs) throws SeatNotAvailable;
}
