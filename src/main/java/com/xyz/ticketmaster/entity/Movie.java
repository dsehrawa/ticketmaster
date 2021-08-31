package com.xyz.ticketmaster.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    private int movieID;
    private String title;
    private String description;
    private String duration;
    private String language;
    private LocalDate releaseDate;
    private String country;
    private String genre;

    @JsonIgnore
    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY)
    private Set<MovieShow> movieShows;
}
