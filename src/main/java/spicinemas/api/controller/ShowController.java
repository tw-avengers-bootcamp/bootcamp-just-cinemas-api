package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.model.Show;
import spicinemas.api.service.ShowService;

import java.util.List;

@RestController
public class ShowController {

    @Autowired
    private ShowService showService;

    @RequestMapping(value = "/v1/show/{id}/{location}/{status}",
            method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Show> getMovieDetail(@PathVariable("id") long movie_id, long locationId, String status) {
        return showService.getShows(movie_id,status,locationId);
    }
}
