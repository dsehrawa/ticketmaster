package com.xyz.ticketmaster.proxy;

import com.xyz.ticketmaster.api.TheatreProxy;
import com.xyz.ticketmaster.exception.SeatNotAvailable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TheatreProxyImpl implements TheatreProxy {
    @Override
    public void lockSeats(int showID, List<Integer> cinemaSeatIDs) throws SeatNotAvailable {
        //to need to implement that
        return;
    }
}
