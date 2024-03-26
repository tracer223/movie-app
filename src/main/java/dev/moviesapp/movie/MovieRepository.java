package main.java.dev.moviesapp.movie;


import org.springframework.data.jpa.repository.JpaRepository;
import com.example.movieapi.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String> {
    // You can add custom query methods here if needed
}