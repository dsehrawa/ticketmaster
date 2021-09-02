package com.xyz.ticketmaster.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Builder
@Data
public class BookingDTO {
    private int numberOfSeats;
    private int showID;
    private int cinemaID;
    private List<Integer> cinemaSeatIDs = new ArrayList<>();
}
