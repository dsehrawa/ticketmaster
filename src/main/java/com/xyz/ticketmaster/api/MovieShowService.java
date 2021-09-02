package com.xyz.ticketmaster.api;

import com.xyz.ticketmaster.dto.MovieShowView;

import java.time.LocalDate;
import java.util.List;

public interface MovieShowService {
    List<MovieShowView> getByMovieIdAndShowDate(int movieID, LocalDate showDate);
}
