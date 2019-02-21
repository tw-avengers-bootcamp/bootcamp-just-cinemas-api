package spicinemas.api.db.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Null;

@Entity(name = "movie_location")
public class MovieLocationEntity {

  @Id
  @GeneratedValue
  private Long id;

  @OneToOne
  @JoinColumn(name = "movie_id")
  private MovieEntity movie;

  @OneToOne
  @JoinColumn(name = "location_id")
  private LocationEntity location;


  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public MovieEntity getMovie() {
    return movie;
  }

  public void setMovie(MovieEntity movie) {
    this.movie = movie;
  }

  public LocationEntity getLocation() {
    return location;
  }

  public void setLocation(LocationEntity location) {
    this.location = location;
  }
}
