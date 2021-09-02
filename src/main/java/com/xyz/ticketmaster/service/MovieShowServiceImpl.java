package com.xyz.ticketmaster.service;

import com.xyz.ticketmaster.api.MovieShowService;
import com.xyz.ticketmaster.dto.MovieShowView;
import com.xyz.ticketmaster.repository.MovieShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieShowServiceImpl implements MovieShowService {

    @Autowired
    private MovieShowRepository movieShowRepository;

    @Override
    public List<MovieShowView> getByMovieIdAndShowDate(int movieID, LocalDate showDate) {
        return movieShowRepository.findByMovieIDAndDate(movieID, showDate);
    }
}
