package com.xyz.ticketmaster.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movie_show")
public class MovieShow {

    @Id
    private int showID;
    private LocalDateTime date;
    private LocalDateTime startTime;
    private LocalDateTime endtime;
    private int cinemaHallID;
    private int movieID;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(insertable = false, updatable = false, name = "cinemaHallID", referencedColumnName = "cinemaHallID")
    private CinemaHall cinemaHall;

    @JsonIgnoreProperties
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(insertable = false, updatable = false, name = "movieID")
    private Movie movie;
}
