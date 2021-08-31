package com.xyz.ticketmaster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cinema_hall")
public class CinemaHall {

    @Id
    private int cinemaHallID;
    private String name;
    private String totalSeats;
    private String cinemaID;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false, name = "cinemaID")
    private Cinema cinema;

    @JsonIgnore
    @OneToMany(mappedBy = "cinemaHall", fetch = FetchType.LAZY)
    private Set<CinemaSeat> cinemaSeats;

    @JsonIgnore
    @OneToMany(mappedBy = "cinemaHall", fetch = FetchType.LAZY)
    private List<MovieShow> movieShows;
}
