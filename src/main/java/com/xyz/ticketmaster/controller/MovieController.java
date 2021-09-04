package com.xyz.ticketmaster.controller;

import com.xyz.ticketmaster.api.MovieService;
import com.xyz.ticketmaster.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/ticketmaster/api/v1/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping("/{city}")
    public Set<Movie> getMoviesByCity(@PathVariable("city") String city) {
        Set<Movie> movieList = movieService.getMoviesByCity(city);
        return movieList;
    }
}
