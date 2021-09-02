package com.xyz.ticketmaster.booking;

import com.xyz.ticketmaster.api.TheatreProxy;
import com.xyz.ticketmaster.exception.SeatNotAvailable;
import com.xyz.ticketmaster.model.OnBoardingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NonReservedStrategy implements BookingStrategy {

    @Autowired
    private TheatreProxy theatreProxy;

    @Override
    public OnBoardingStrategy getType(){
        return OnBoardingStrategy.NON_RESERVED;
    }

    @Override
    public void lockSeats(int showID, List<Integer> cinemaSeatIDs) throws SeatNotAvailable {
        theatreProxy.lockSeats(showID, cinemaSeatIDs);
    }
}
