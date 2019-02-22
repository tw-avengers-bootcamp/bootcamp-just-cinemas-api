package spicinemas.api.db;

import com.sun.istack.internal.NotNull;
import java.time.LocalDate;
import java.util.Date;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.db.entities.MovieLocationEntity;
import spicinemas.api.db.entities.ShowEntity;

public class ShowBuilder {

    private ShowEntity showEntity;
    private MovieLocationEntity movieLocationEntity;
    private ShowBuilder(){
      showEntity=new ShowEntity();
    }

    public ShowBuilder setMovieAndLocation(String movieName, String synopsis,String locationName){
      movieLocationEntity = new MovieLocationEntity();
      MovieEntity movieEntity = new MovieEntity();
      movieEntity.setName(movieName);
      movieEntity.setSynopsis(synopsis);
      movieLocationEntity.setMovie(movieEntity);
      LocationEntity locationEntity = new LocationEntity();
      locationEntity.setName(locationName);
      MovieLocationEntity movieLocationEntity = new MovieLocationEntity();
      movieLocationEntity.setMovie(movieEntity);
      movieLocationEntity.setLocation(locationEntity);
      showEntity.setMovieLocation(movieLocationEntity);
      return this;
    }


    public ShowBuilder setOptionalAvailableSeats(Long noOfSeats){
      showEntity.setMaxSeats(noOfSeats);
      return this;
    }

    public ShowEntity build(){
      return showEntity;
    }


    public static ShowBuilder getInstance(){
      return  new ShowBuilder();
    }



}
