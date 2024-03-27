package dev.moviesapp.movie;

public class MovieServiceException extends RuntimeException {

    public MovieServiceException(String message) {
        super(message);
    }

    public MovieServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
