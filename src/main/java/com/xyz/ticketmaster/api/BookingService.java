package com.xyz.ticketmaster.api;

import com.xyz.ticketmaster.dto.BookingDTO;
import com.xyz.ticketmaster.entity.Booking;
import com.xyz.ticketmaster.exception.SeatNotAvailable;

public interface BookingService {
    Booking createBooking(BookingDTO bookingDTO) throws SeatNotAvailable;
}
