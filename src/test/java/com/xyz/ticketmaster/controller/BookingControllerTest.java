package com.xyz.ticketmaster.controller;

import com.xyz.ticketmaster.api.BookingService;
import com.xyz.ticketmaster.common.BookingStatus;
import com.xyz.ticketmaster.dto.BookingDTO;
import com.xyz.ticketmaster.entity.Booking;
import com.xyz.ticketmaster.exception.SeatNotAvailable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class BookingControllerTest {
    @Mock
    private BookingService bookingService;

    @InjectMocks
    private BookingController bookingController;

    @Test
    public void testCreateBooking() throws SeatNotAvailable {
        BookingDTO bookingDTO =
                BookingDTO.builder().numberOfSeats(2).showID(1).cinemaID(1).cinemaSeatIDs(Arrays.asList(1, 2)).build();

        Booking booking = new Booking(1, 2, new Timestamp(new Date().getTime()), BookingStatus.RESERVED.getValue(), 1, 1);
        Mockito.when(bookingService.createBooking(Mockito.any(BookingDTO.class))).thenReturn(booking);
        Booking retBooking = bookingController.createBooking(bookingDTO);
        assertThat(retBooking).isNotNull();
        assertThat(retBooking).isEqualTo(booking);
    }

}
