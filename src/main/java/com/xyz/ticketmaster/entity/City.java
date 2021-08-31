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
@Table(name = "city")
public class City {

    @Id
    private int cityID;
    private String name;
    private String state;
    private String zipCode;

    @JsonIgnore
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY)
    private Set<Cinema> cinemas;

}
