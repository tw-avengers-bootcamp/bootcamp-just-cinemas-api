package spicinemas.api.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.db.MovieRepository;
import spicinemas.api.model.Location;
import spicinemas.api.model.Movie;
import spicinemas.api.service.LocationService;

@RestController
public class LocationController {

  private LocationService locationService;

  public LocationController(LocationService locationService) {
    this.locationService = locationService;
  }

  @RequestMapping(value = "/locations",
      method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  public List<Location> getLocations(){
    return locationService.getLocations();
  }
}
