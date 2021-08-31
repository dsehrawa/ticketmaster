package com.xyz.ticketmaster.repository;

import com.xyz.ticketmaster.dto.MovieShowView;
import com.xyz.ticketmaster.entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Integer> {

    @Query(value = "SELECT\n" +
            "  movie_show.startTime,\n" +
            "  movie_show.endtime,\n" +
            "  cinema_hall.name as cinema_hall_name,\n" +
            "  cinema.name as cinema_name,\n" +
            "  city.name as city_name\n" +
            "FROM movie_show \n" +
            "JOIN cinema_hall\n" +
            "  ON movie_show.cinemaHallID = cinema_hall.cinemaHallID\n" +
            "JOIN cinema\n" +
            "  ON cinema.cinemaID = cinema_hall.cinemaID\n" +
            "JOIN city\n" +
            "  ON city.cityID = cinema.cityID\n" +
            "where movie_show.movieID=:movieID and date=:showDate", nativeQuery = true)
    List<MovieShowView> findByMovieIDAndDate(int movieID, LocalDate showDate);
}
