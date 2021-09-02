package com.xyz.ticketmaster.controller;

import com.xyz.ticketmaster.api.BookingService;
import com.xyz.ticketmaster.dto.BookingDTO;
import com.xyz.ticketmaster.entity.Booking;
import com.xyz.ticketmaster.exception.SeatNotAvailable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticketmaster/api/v1/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking createBooking(@RequestBody BookingDTO bookingDTO) throws SeatNotAvailable {
        return bookingService.createBooking(bookingDTO);
    }
}
