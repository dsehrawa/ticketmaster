package com.xyz.ticketmaster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
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

    @JsonIgnoreProperties
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false, name = "cinemaID")
    private Cinema cinema;

    @JsonIgnore
    @OneToMany(mappedBy = "cinemaHall", fetch = FetchType.LAZY)
    private Set<CinemaSeat> cinemaSeats;

    @OneToOne(mappedBy = "cinemaHall")
    private MovieShow movieShow;
}
