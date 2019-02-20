package spicinemas.api.controller;

import org.springframework.web.bind.annotation.*;
import spicinemas.api.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.service.MovieService;


import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;

    @RequestMapping(value = "/v1/movies/{location}/{status}/",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Movie> getNowShowingMovies(@PathVariable("location") Long location,
                                           @PathVariable("status") String status,
                                           @RequestParam(value = "language", required = false) String language) {
        return movieService.getMoviesByLocationAndStatus(location, status);
    }


    @RequestMapping(value = "/v1/movies/{id}/",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Movie getMovieDetail(@PathVariable("id") long movie_id) {
        return movieService.getMovieDetails(movie_id);
    }


}
