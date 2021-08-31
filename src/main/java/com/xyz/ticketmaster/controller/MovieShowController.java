package com.xyz.ticketmaster.controller;

import com.xyz.ticketmaster.entity.MovieShow;
import com.xyz.ticketmaster.service.MovieShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ticketmaster/api/v1/shows")
public class MovieShowController {
    @Autowired
    private MovieShowService movieShowService;

    @GetMapping("/filter")
    public List<MovieShow> getShows(@RequestParam("movieID") int movieID,
                                    @RequestParam("showDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate showDate) {

        return movieShowService.getByMovieIdAndShowDate(movieID, showDate);
    }
}