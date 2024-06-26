package dev.moviesapp.movie.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.moviesapp.movie.pojo.Movie;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/fetch-movie")
    public ResponseEntity<Movie> fetchMovieFromApi(@RequestParam String title) {
        Movie movie = movieService.getMovieDetailsByTitle(title);
        return ResponseEntity.ok(movie);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title) {
        List<Movie> movies = movieService.searchMovies(title);
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/details/{imdbId}")
    public ResponseEntity<Movie> getMovieDetails(@PathVariable String imdbId) {
        Movie movie = movieService.getMovieDetailsByImdbId(imdbId);
        return ResponseEntity.ok(movie);
    }
}

