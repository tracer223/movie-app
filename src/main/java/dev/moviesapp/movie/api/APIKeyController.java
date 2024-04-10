package dev.moviesapp.movie.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class APIKeyController {

    @Value("${omdb.api.key}")
    private String omdbApiKey;

    @GetMapping("/api-key")
    public ResponseEntity<String> getAPIKey() {
        return ResponseEntity.ok(omdbApiKey);
    }
}
