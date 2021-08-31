package com.xyz.ticketmaster.service;

import com.xyz.ticketmaster.entity.MovieShow;
import com.xyz.ticketmaster.repository.MovieShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieShowService {

    @Autowired
    private MovieShowRepository movieShowRepository;

    public List<MovieShow> getByMovieIdAndShowDate(int movieID, LocalDate showDate) {
        return movieShowRepository.findByMovieIDAndDate(movieID, showDate);
    }
}
