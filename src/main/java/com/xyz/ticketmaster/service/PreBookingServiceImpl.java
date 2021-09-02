package com.xyz.ticketmaster.service;

import com.xyz.ticketmaster.api.PreBookingService;
import com.xyz.ticketmaster.dto.BookingDTO;
import com.xyz.ticketmaster.entity.PreBooking;
import com.xyz.ticketmaster.exception.SeatNotAvailable;
import com.xyz.ticketmaster.repository.PreBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PreBookingServiceImpl implements PreBookingService {

    @Autowired
    private PreBookingRepository preBookingRepository;

    @Override
    public void lockSeats(int showID, List<Integer> cinemaSeatIDs) throws SeatNotAvailable {
        List<PreBooking> createdPreBookings = new ArrayList<>();
        for (int cinemaSeatId : cinemaSeatIDs) {
            try {
                PreBooking preBooking =
                        PreBooking.builder().cinemaSeatID(cinemaSeatId).showID(showID).userID(1).build();
                createdPreBookings.add(preBookingRepository.save(preBooking));
            } catch (DataIntegrityViolationException ex) {
                preBookingRepository.deleteAll(createdPreBookings);
                throw new SeatNotAvailable("Seat is already taken");
            }
        }

    }
}
