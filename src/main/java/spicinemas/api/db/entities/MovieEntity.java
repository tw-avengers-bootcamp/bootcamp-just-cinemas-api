package spicinemas.api.db.entities;

import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity(name = "movie")
public class MovieEntity {

  @Id
  @GeneratedValue
  private Long id;


  private String name;
  private String synopsis;

  @JoinColumn(name = "language_id")
  @OneToOne
  private LanguageEntity language;

  @JoinColumn(name = "status_id")
  @OneToOne
  private StatusEntity status;


  @OneToMany(targetEntity = LocationEntity.class,fetch = FetchType.EAGER)
  @JoinTable(
      name="Movie_Location",
      joinColumns = @JoinColumn( name="movie_id"),
      inverseJoinColumns = @JoinColumn( name="location_id")


  )
  private Set<LocationEntity> locations;



  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public LanguageEntity getLanguage() {
    return language;
  }

  public void setLanguage(LanguageEntity language) {
    this.language = language;
  }

  public StatusEntity getStatus() {
    return status;
  }

  public void setStatus(StatusEntity status) {
    this.status = status;
  }

  public Set<LocationEntity> getLocations() {
    return locations;
  }

  public void setLocations(Set<LocationEntity> locations) {
    this.locations = locations;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSynopsis() {
    return synopsis;
  }

  public void setSynopsis(String synopsis) {
    this.synopsis = synopsis;
  }
}
