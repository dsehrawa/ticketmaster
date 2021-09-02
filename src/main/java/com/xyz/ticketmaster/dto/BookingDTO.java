package com.xyz.ticketmaster.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class BookingDTO {
    private int numberOfSeats;
    private int showID;
    private int cinemaSeatID;
}
