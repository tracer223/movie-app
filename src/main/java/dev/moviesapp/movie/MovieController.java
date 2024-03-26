package dev.moviesapp.movie;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title) {
        List<Movie> movies = new ArrayList<>();
        movies.add(movieService.searchMovieByTitle(title));
        System.out.println(Array.toString(movies));
        return ResponseEntity.ok(movies);
    }

    @GetMapping("/details/{imdbId}")
    public ResponseEntity<Movie> getMovieDetails(@PathVariable String imdbId) {
        Movie movie = movieService.getMovieDetailsByImdbId(imdbId);
        return ResponseEntity.ok(movie);
    }
}

