package com.xyz.ticketmaster.booking;

import com.xyz.ticketmaster.api.PreBookingService;
import com.xyz.ticketmaster.exception.SeatNotAvailable;
import com.xyz.ticketmaster.common.OnBoardingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReservedStrategy implements BookingStrategy {
    @Autowired
    private PreBookingService preBookingService;

    @Override
    public OnBoardingStrategy getType(){
        return OnBoardingStrategy.RESERVED;
    }

    @Override
    public void lockSeats(int showID, List<Integer> cinemaSeatIDs) throws SeatNotAvailable {
        preBookingService.lockSeats(showID, cinemaSeatIDs);
    }
}
