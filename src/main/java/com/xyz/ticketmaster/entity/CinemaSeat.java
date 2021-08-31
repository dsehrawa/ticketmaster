package com.xyz.ticketmaster.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cinema_seat")
public class CinemaSeat {

    @Id
    private int cinemaSeatID;
    private int seatNumber;
    private int type;
    private int cinemaHallID;
}
