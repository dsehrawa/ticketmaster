package com.xyz.ticketmaster.service;

import com.xyz.ticketmaster.api.BookingService;
import com.xyz.ticketmaster.api.PreBookingService;
import com.xyz.ticketmaster.booking.BookingStrategyFactory;
import com.xyz.ticketmaster.dto.BookingDTO;
import com.xyz.ticketmaster.entity.Booking;
import com.xyz.ticketmaster.entity.ShowSeat;
import com.xyz.ticketmaster.exception.SeatNotAvailable;
import com.xyz.ticketmaster.common.BookingStatus;
import com.xyz.ticketmaster.common.OnBoardingStrategy;
import com.xyz.ticketmaster.common.SeatStatus;
import com.xyz.ticketmaster.repository.BookingRepository;
import com.xyz.ticketmaster.repository.CinemaRepository;
import com.xyz.ticketmaster.repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private PreBookingService preBookingService;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private CinemaRepository cinemaRepository;


    private void lockSeats(BookingDTO bookingDTO) throws SeatNotAvailable {
        OnBoardingStrategy onBoardingStrategy =
                OnBoardingStrategy.fromValue(cinemaRepository.findById(bookingDTO.getCinemaID()).get().getOnBoardingStrategy());
        BookingStrategyFactory.getBookingStrategy(onBoardingStrategy).lockSeats(bookingDTO.getShowID(),
                bookingDTO.getCinemaSeatIDs());
    }

    public Booking createBooking(BookingDTO bookingDTO) throws SeatNotAvailable {
        lockSeats(bookingDTO);

        //create booking
        Booking booking = new Booking();
        booking.setNumberOfSeats(bookingDTO.getNumberOfSeats());
        booking.setBookingTime(new Timestamp((new Date()).getTime()));
        booking.setStatus(BookingStatus.RESERVED.getValue());
        booking.setUserID(1);//Ideally it should be get from logged into user session
        booking.setShowID(bookingDTO.getShowID());
        booking = bookingRepository.save(booking);

        //update Show Seat
        for (int cinemaSeatId : bookingDTO.getCinemaSeatIDs()) {
            ShowSeat showSeat = showSeatRepository.findByCinemaSeatIDAndShowID(cinemaSeatId,
                    bookingDTO.getShowID());
            showSeat.setBookingID(booking.getBookingID());
            showSeat.setStatus(SeatStatus.RESERVED.getValue());
            showSeatRepository.save(showSeat);
        }

        return booking;
    }

}
