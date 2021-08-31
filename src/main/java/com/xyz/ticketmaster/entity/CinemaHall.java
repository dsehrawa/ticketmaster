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
@Table(name = "cinema_hall")
public class CinemaHall {

    @Id
    private int cinemaHallID;
    private String name;
    private String totalSeats;
    private String cinemaID;
}
