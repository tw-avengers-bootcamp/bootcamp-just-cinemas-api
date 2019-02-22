package spicinemas.api.controller;


import java.util.List;
import spicinemas.api.db.LocationRepository;
import spicinemas.api.db.MovieLocationRepository;
import spicinemas.api.db.MoviesRepository;
import spicinemas.api.db.ShowRepository;
import spicinemas.api.db.StatusRepository;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.db.entities.MovieLocationEntity;
import spicinemas.api.db.entities.StatusEntity;
import spicinemas.api.model.Show;

public class ShowController {
    private MovieLocationRepository movieLocationRepository;
    private MoviesRepository moviesRepository;
    private LocationRepository locationRepository;
    private ShowRepository showRepository;
    private StatusRepository statusRepository;


  public ShowController(MovieLocationRepository movieLocationRepository,MoviesRepository moviesRepository, LocationRepository locationRepository,
      ShowRepository showRepository, StatusRepository statusRepository) {
      this.moviesRepository=moviesRepository;
      this.locationRepository=locationRepository;
      this.showRepository=showRepository;
      this.statusRepository=statusRepository;
      this.movieLocationRepository=movieLocationRepository;

  }

  public List<Show> getShows(Long movieId,Long statusId,Long locationId){
    StatusEntity statusEntity = statusRepository.findOne(statusId);
    MovieEntity movieEntity = moviesRepository.findOne(locationId);
    LocationEntity locationEntity= locationRepository.findOne(locationId);
    MovieLocationEntity movieLocationEntity = movieLocationRepository.findByLocationAndMovie(locationEntity,movieEntity);
    return  null;
  }




}
