package com.xyz.ticketmaster.booking;

import com.xyz.ticketmaster.exception.InvalidOnBoardingStrategyException;
import com.xyz.ticketmaster.model.OnBoardingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

@Component
public class BookingStrategyFactory {

    private static final Map<OnBoardingStrategy, BookingStrategy> bookingStrategiesMap = new EnumMap<>(OnBoardingStrategy.class);

    @Autowired
    private BookingStrategyFactory(List<BookingStrategy> bookingStrategies) {
        for (BookingStrategy bookingStrategy : bookingStrategies) {
            bookingStrategiesMap.put(bookingStrategy.getType(), bookingStrategy);
        }
    }

    public static BookingStrategy getBookingStrategy(OnBoardingStrategy onBoardingStrategy) {
        BookingStrategy bookingStrategy = bookingStrategiesMap.get(onBoardingStrategy);
        if (bookingStrategy == null) {
            throw new InvalidOnBoardingStrategyException("Unknown OnBoardingStrategy");
        }
        return bookingStrategy;
    }
}
