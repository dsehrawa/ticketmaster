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
@Table(name = "show")
public class Show {

    @Id
    private int showID;
    private LocalDateTime date;
    private LocalDateTime startTime;
    private LocalDateTime endtime;
    private int cinemaHallID;
    private int movieID;
}
