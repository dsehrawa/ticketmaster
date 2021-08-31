package com.xyz.ticketmaster.service;

import com.xyz.ticketmaster.entity.Cinema;
import com.xyz.ticketmaster.entity.CinemaHall;
import com.xyz.ticketmaster.entity.City;
import com.xyz.ticketmaster.entity.Movie;
import com.xyz.ticketmaster.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<Movie> getMoviesByCity(String cityName) {
        List<Movie> movieList = new ArrayList<>();
        City retCity
                = cityRepository.findAll().stream().filter((city) -> cityName.equals(city.getName())).findFirst().get();

        Set<Cinema> cinemas = retCity.getCinemas();

        for (Cinema cinema : cinemas) {
            Set<CinemaHall> cinemaHalls = cinema.getCinemaHalls();
            for (CinemaHall cinemaHall : cinemaHalls) {
                movieList.add(cinemaHall.getMovieShow().getMovie());
            }
        }
        return movieList;
    }
}
