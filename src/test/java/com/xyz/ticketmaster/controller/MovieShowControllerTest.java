package com.xyz.ticketmaster.controller;

import com.xyz.ticketmaster.api.MovieShowService;
import com.xyz.ticketmaster.dto.MovieShowView;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class MovieShowControllerTest {

    @Mock
    private MovieShowService movieShowService;

    @InjectMocks
    private MovieShowController movieShowController;

    class MovieShowViewImpl implements MovieShowView {
        private LocalDateTime statTime;
        private LocalDateTime endTime;
        private String cinema_hall_name;
        private String cinema_name;
        private String city_name;

        public MovieShowViewImpl(LocalDateTime statTime, LocalDateTime endTime, String cinema_hall_name,
                                 String cinema_name, String city_name) {
            this.statTime = statTime;
            this.endTime = endTime;
            this.cinema_hall_name = cinema_hall_name;
            this.cinema_name = cinema_name;
            this.city_name = city_name;
        }

        @Override
        public LocalDateTime getStartTime() {
            return statTime;
        }

        @Override
        public LocalDateTime getEndtime() {
            return endTime;
        }

        @Override
        public String getCinema_hall_name() {
            return cinema_hall_name;
        }

        @Override
        public String getCinema_name() {
            return cinema_name;
        }

        @Override
        public String getCity_name() {
            return city_name;
        }
    }

    @Test
    public void testGetShows() {
        MovieShowView movieShowView1 = new MovieShowViewImpl(LocalDateTime.of(2021, 8, 31, 0, 0, 0),
                LocalDateTime.of(2021, 8, 31, 10, 0, 0),
                "Ganga", "PVR", "Vasant Kunj, New Delhi");

        MovieShowView movieShowView2 = new MovieShowViewImpl(LocalDateTime.of(2021, 8, 31, 0, 0, 0),
                LocalDateTime.of(2021, 8, 31, 10, 0, 0),
                "Yamuna", "PVR", "Vasant Kunj, New Delhi");

        MovieShowView movieShowView3 = new MovieShowViewImpl(LocalDateTime.of(2021, 8, 31, 0, 0, 0),
                LocalDateTime.of(2021, 8, 31, 10, 0, 0),
                "2D", "Inox", "Vasant Kunj, New Delhi");

        List<MovieShowView> movieShowViewList = Arrays.asList(movieShowView1, movieShowView2, movieShowView3);
        Mockito.when(movieShowService.getByMovieIdAndShowDate(Mockito.anyInt(), Mockito.any(LocalDate.class))).thenReturn(movieShowViewList);

        List<MovieShowView> retMovieShowViewList = movieShowController.getShows(1, LocalDate.now());

        assertThat(retMovieShowViewList.size()).isEqualTo(3);
        assertThat("PVR").isEqualTo(retMovieShowViewList.get(0).getCinema_name());
        assertThat("Ganga").isEqualTo(retMovieShowViewList.get(0).getCinema_hall_name());

        assertThat("PVR").isEqualTo(retMovieShowViewList.get(1).getCinema_name());
        assertThat("Yamuna").isEqualTo(retMovieShowViewList.get(1).getCinema_hall_name());

        assertThat("Inox").isEqualTo(retMovieShowViewList.get(2).getCinema_name());
        assertThat("2D").isEqualTo(retMovieShowViewList.get(2).getCinema_hall_name());
    }
}
