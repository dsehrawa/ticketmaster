package com.xyz.ticketmaster.service;

import com.xyz.ticketmaster.api.MovieService;
import com.xyz.ticketmaster.entity.Cinema;
import com.xyz.ticketmaster.entity.CinemaHall;
import com.xyz.ticketmaster.entity.City;
import com.xyz.ticketmaster.entity.Movie;
import com.xyz.ticketmaster.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public Set<Movie> getMoviesByCity(String cityName) {
        Set<Movie> movieList = new HashSet<>();
        City retCity
                = cityRepository.findAll().stream().filter((city) -> cityName.equals(city.getName())).findFirst().get();

        Set<Cinema> cinemas = retCity.getCinemas();

        for (Cinema cinema : cinemas) {
            Set<CinemaHall> cinemaHalls = cinema.getCinemaHalls();
            for (CinemaHall cinemaHall : cinemaHalls) {
                movieList.addAll(cinemaHall.getMovieShows().stream().map(movieShow -> movieShow.getMovie()).collect(Collectors.toList()));
            }
        }
        return movieList;
    }
}
