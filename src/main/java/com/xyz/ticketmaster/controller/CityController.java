package com.xyz.ticketmaster.controller;

import com.xyz.ticketmaster.entity.Movie;
import com.xyz.ticketmaster.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/{city}")
    public Set<Movie> getMoviesByCity(@PathVariable("city") String city) {
        Set<Movie> movieList = cityService.getMoviesByCity(city);
        return movieList;
    }
}