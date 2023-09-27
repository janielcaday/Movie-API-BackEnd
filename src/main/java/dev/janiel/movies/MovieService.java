package dev.janiel.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Where most of the business logic will go.
 * Uses the repository class and talks to the database, gets the list of movies,
 * and returns it to the API layer
 */
@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId) {return movieRepository.findMovieByImdbId(imdbId); }
}
