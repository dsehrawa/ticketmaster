package com.xyz.ticketmaster.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    private int movieID;
    private String title;
    private String description;
    private String duration;
    private String language;
    private LocalDateTime releaseDate;
    private String country;
    private String genre;
}
