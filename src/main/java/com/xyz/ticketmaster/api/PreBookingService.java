package com.xyz.ticketmaster.api;

import com.xyz.ticketmaster.exception.SeatNotAvailable;

import java.util.List;

public interface PreBookingService {
    void lockSeats(int showID, List<Integer> cinemaSeatIDs) throws SeatNotAvailable;
}
