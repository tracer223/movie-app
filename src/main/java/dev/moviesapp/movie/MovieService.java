package dev.moviesapp.movie;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    private final RestTemplate restTemplate;
    private final String omdbApiBaseUrl;
    private final String omdbApiKey;

    public MovieService(RestTemplate restTemplate,
                          @Value("${omdb.api.base-url}") String omdbApiBaseUrl,
                          @Value("${omdb.api.key}") String omdbApiKey) {
        this.restTemplate = restTemplate;
        this.omdbApiBaseUrl = omdbApiBaseUrl;
        this.omdbApiKey = omdbApiKey;
    }

    public Movie searchMovieByTitle(String title) {
        String url = omdbApiBaseUrl + "?apikey=" + omdbApiKey + "&s=" + title;
        return restTemplate.getForObject(url, Movie.class);
    }

    public Movie getMovieDetailsByImdbId(String imdbId) {
        String url = omdbApiBaseUrl + "?apikey=" + omdbApiKey + "&i=" + imdbId;
        return restTemplate.getForObject(url, Movie.class);
    }

    // Other methods for fetching additional information about movies

    // Define your Movie class with relevant fields (title, year, plot, etc.)
    // ...

    // You can also handle exceptions, logging, and other aspects as needed.
}
