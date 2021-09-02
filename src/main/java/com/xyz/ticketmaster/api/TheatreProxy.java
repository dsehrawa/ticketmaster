package com.xyz.ticketmaster.api;

import com.xyz.ticketmaster.exception.SeatNotAvailable;

import java.util.List;

public interface TheatreProxy {
    void lockSeats(int showID, List<Integer> cinemaSeatIDs) throws SeatNotAvailable;
}
