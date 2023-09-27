package dev.janiel.movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ObjectInput;
import java.util.List;
import java.util.Optional;

/**
 * In REST API's, there are usually multiple layers.
 * One is the API layer (Controller) – will only concern itself with the task
 * of getting a response from the user and nothing else.
 * This is using a service class and delegating the task of fetching all the movies
 * from the database and giving it back to the API layer.
 *
 * Calls the method in service, gets the list of movies,
 * and returns them with HTTP status 200
 *
 */
@RestController
@RequestMapping("/api/v1/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping ("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }
}
