package spicinemas.api.service;


import org.springframework.stereotype.Service;
import spicinemas.api.db.*;
import spicinemas.api.db.entities.*;
import spicinemas.api.model.Movie;
import spicinemas.api.model.Show;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShowService {
    private MovieLocationRepository movieLocationRepository;
    private MoviesRepository moviesRepository;
    private LocationRepository locationRepository;
    private ShowRepository showRepository;
    private StatusRepository statusRepository;


  public ShowService(MovieLocationRepository movieLocationRepository, MoviesRepository moviesRepository, LocationRepository locationRepository,
                     ShowRepository showRepository, StatusRepository statusRepository) {
      this.moviesRepository=moviesRepository;
      this.locationRepository=locationRepository;
      this.showRepository=showRepository;
      this.statusRepository=statusRepository;
      this.movieLocationRepository=movieLocationRepository;
  }


  public List<Show> getShows(Long movieId,String statusName,Long locationId){
    List<StatusEntity> status = statusRepository.findByType(statusName);
    StatusEntity statusEntity = status.get(0);
    MovieEntity movieEntity = moviesRepository.findOne(movieId);
    LocationEntity locationEntity= locationRepository.findOne(locationId);
    MovieLocationEntity movieLocationEntity = movieLocationRepository.findByLocationAndMovie(locationEntity,movieEntity);
    Timestamp currentDate= Timestamp.valueOf(LocalDateTime.now().toLocalDate().atStartOfDay());
    List<ShowEntity> showEntities= showRepository.findByMovieLocationAndStatus(movieLocationEntity,statusEntity,currentDate);
      return showEntities.stream().map((showEntity) -> {
          Show show = new Show();
          show.setId(showEntity.getId());
          show.setMaxSeats(showEntity.getMaxSeats());
          show.setMovieLocation(showEntity.getMovieLocation());
          show.setShowDate(showEntity.getShowDate());
          show.setAmount(showEntity.getAmount());
          return show;
      }).collect(Collectors.toList());
  }


}
