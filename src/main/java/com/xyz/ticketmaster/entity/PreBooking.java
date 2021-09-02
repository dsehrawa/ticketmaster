package com.xyz.ticketmaster.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "pre_booking")
public class PreBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int preBookingId;
    private int cinemaSeatID;
    private int showID;
    private int userID;
}
