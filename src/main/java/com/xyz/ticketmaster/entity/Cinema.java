package com.xyz.ticketmaster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cinema")
public class Cinema {

    @Id
    private int cinemaID;
    private String name;
    private int totalCienaHalls;
    private int cityID;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(insertable = false, updatable = false, name = "cityID")
    private City city;

    @JsonIgnore
    @OneToMany(mappedBy = "cinema", fetch = FetchType.LAZY)
    private Set<CinemaHall> cinemaHalls;
}
