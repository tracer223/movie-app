package dev.moviesapp.movie;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
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

    public List<Movie> searchMovies(String title) {
        String url = omdbApiBaseUrl + "?apikey=" + omdbApiKey + "&s=" + title;
        ResponseEntity<SearchResponse> responseEntity = restTemplate.getForEntity(url, SearchResponse.class);
        SearchResponse searchResponse = responseEntity.getBody();
        return searchResponse != null ? searchResponse.getSearch() : null;
    }

    public Movie getMovieDetailsByImdbId(String imdbId) {
        String url = omdbApiBaseUrl + "?apikey=" + omdbApiKey + "&i=" + imdbId;
        return restTemplate.getForObject(url, Movie.class);
    }

    public Movie getMovieDetailsByTitle(String title) {
    try {
        String url = omdbApiBaseUrl + "?apikey=" + omdbApiKey + "&t=" + title;
        return restTemplate.getForObject(url, Movie.class);
    } catch (RestClientException e) {
        throw new MovieServiceException("Failed to retrieve movie details from the external API", e);
    }
}

}
