package dev.moviesapp.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Movie {
    private String title;
    private int year;
    private int imdbId;
}
