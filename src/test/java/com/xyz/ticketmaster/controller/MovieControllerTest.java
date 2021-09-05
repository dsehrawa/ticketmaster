package com.xyz.ticketmaster.controller;

import com.xyz.ticketmaster.api.MovieService;
import com.xyz.ticketmaster.entity.Movie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.util.collections.Sets;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class MovieControllerTest {

    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @Test
    public void testGetMoviesByCity() {
        Movie movie1 = new Movie(1, "Bell Bottom", "Amongst multiple heinous airplane hijacks, India was made to face" +
                " another such challenge in 1984.",
                "3h", "Hindi", LocalDate.now(), "India", "Action", null);

        Movie movie2 = new Movie(2, "Fast and Furious 9", "Dom`s peaceful life with his wife Letty and son Brian is shattered when Dom`s past catches up to him.",
                "2h", "English", LocalDate.now(), "USA", "Action", null);

        Set<Movie> movieSet = Sets.newSet(movie1, movie2);

        Mockito.when(movieService.getMoviesByCity(Mockito.anyString())).thenReturn(movieSet);

        // when
        Set<Movie> result = movieController.getMoviesByCity("Vasant Kunj, New Delhi");

        // then
        assertThat(result.size()).isEqualTo(2);

        Movie[] movies = result.toArray(new Movie[0]);

        assertThat("Bell Bottom").isEqualTo(movies[0].getTitle());
        assertThat("Fast and Furious 9").isEqualTo(movies[1].getTitle());
    }
}
