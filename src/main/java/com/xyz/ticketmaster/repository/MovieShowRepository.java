package com.xyz.ticketmaster.repository;

import com.xyz.ticketmaster.entity.MovieShow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieShowRepository extends JpaRepository<MovieShow, Integer> {
    List<MovieShow> findByMovieIDAndDate(int movieID, LocalDate showDate);
}
