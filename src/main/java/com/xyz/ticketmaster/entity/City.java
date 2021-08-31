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
@Table(name = "city")
public class City {

    @Id
    private int cityID;
    private String name;
    private String state;
    private String zipCode;
}
