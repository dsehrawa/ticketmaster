package com.xyz.ticketmaster.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "show_seat")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ShowSeat {
    @Id
    private int showSeatID;
    private int status;
    private double price;
    private int cinemaSeatID;
    private int showID;
    private Integer bookingID;
}
