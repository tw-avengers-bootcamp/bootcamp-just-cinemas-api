package spicinemas.api.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
@Entity(name="trailer")
public class TrailerEntity {
  @Id
  @GeneratedValue
  private Long id;
  private String url;

  @ManyToOne
  @JoinColumn(name="movie_id")
  private MovieEntity movieEntity;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public MovieEntity getMovieEntity() {
    return movieEntity;
  }

  public void setMovieEntity(MovieEntity movieEntity) {
    this.movieEntity = movieEntity;
  }
}
