package dev.moviesapp.movie.pojo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchResponse {
    @JsonProperty("Search")
    private List<Movie> search;

    public SearchResponse(List<Movie> search) {
        this.search = search;
    }

    public List<Movie> getSearch() {
        return search;
    }

    public void setSearch(List<Movie> search) {
        this.search = search;
    }

}
