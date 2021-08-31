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
@Table(name = "cinema")
public class Cinema {

    @Id
    private int cinemaID;
    private String name;
    private int totalCienaHalls;
    private int cityID;
}
