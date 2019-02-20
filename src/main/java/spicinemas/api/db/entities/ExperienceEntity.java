package spicinemas.api.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity(name = "experience")
public class ExperienceEntity {

  @Id
  @GeneratedValue
  private Long id;
  private String type;

  @ManyToOne
  @JoinColumn(name="movie_id")
  private MovieEntity movieEntity;


  public MovieEntity getMovieEntity() {
    return movieEntity;
  }

  public void setMovieEntity(MovieEntity movieEntity) {
    this.movieEntity = movieEntity;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }



}
