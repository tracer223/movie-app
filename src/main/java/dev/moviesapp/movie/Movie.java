package dev.moviesapp.movie;

import org.springframework.stereotype.Component;

@Component
public class Movie {
    private String title;
    private String imdbId;
    private int year;
    
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getImdbId() {
        return imdbId;
    }
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    
    
}
