package com.xyz.ticketmaster.service;

import com.xyz.ticketmaster.api.BookingService;
import com.xyz.ticketmaster.dto.BookingDTO;
import com.xyz.ticketmaster.entity.Booking;
import com.xyz.ticketmaster.entity.PreBooking;
import com.xyz.ticketmaster.entity.ShowSeat;
import com.xyz.ticketmaster.exception.SeatNotAvailable;
import com.xyz.ticketmaster.model.BookingStatus;
import com.xyz.ticketmaster.model.SeatStatus;
import com.xyz.ticketmaster.repository.BookingRepository;
import com.xyz.ticketmaster.repository.PreBookingRepository;
import com.xyz.ticketmaster.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private PreBookingRepository preBookingRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private BookingRepository bookingRepository;


    private void lockSeat(BookingDTO bookingDTO) throws SeatNotAvailable {
        try {
            PreBooking preBooking =
                    PreBooking.builder().cinemaSeatID(bookingDTO.getCinemaSeatID()).showID(bookingDTO.getShowID()).userID(1).build();
            preBookingRepository.save(preBooking);
        } catch (DataIntegrityViolationException ex) {
            throw new SeatNotAvailable("Seat is already taken");
        }
    }


    public Booking createBooking(BookingDTO bookingDTO) throws SeatNotAvailable {
        lockSeat(bookingDTO);

        //create booking
        Booking booking = new Booking();
        booking.setNumberOfSeats(bookingDTO.getNumberOfSeats());
        booking.setBookingTime(new Timestamp((new Date()).getTime()));
        booking.setStatus(BookingStatus.RESERVED.getValue());
        booking.setUserID(1);//Ideally it should be get from logged into user session
        booking.setShowID(bookingDTO.getShowID());
        booking = bookingRepository.save(booking);

        //update Show Seat
        ShowSeat showSeat = showSeatRepository.findByCinemaSeatIDAndShowID(bookingDTO.getCinemaSeatID(),
                bookingDTO.getShowID());
        showSeat.setBookingID(booking.getBookingID());
        showSeat.setStatus(SeatStatus.RESERVED.getValue());
        showSeatRepository.save(showSeat);

        return booking;
    }

}
