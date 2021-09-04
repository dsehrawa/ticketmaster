package com.xyz.ticketmaster.api;

import com.xyz.ticketmaster.entity.Movie;

import java.util.Set;

public interface MovieService {
    Set<Movie> getMoviesByCity(String cityName);
}
