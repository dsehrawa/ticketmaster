package com.xyz.ticketmaster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cinema_seat")
public class CinemaSeat {

    @Id
    private int cinemaSeatID;
    private int seatNumber;
    private int type;
    private int cinemaHallID;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false, name = "cinemaHallID")
    private CinemaHall cinemaHall;

}
