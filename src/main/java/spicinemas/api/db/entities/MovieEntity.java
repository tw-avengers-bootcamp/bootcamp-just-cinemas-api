package spicinemas.api.db.entities;

import java.util.List;
import java.util.Set;
import javax.persistence.*;

@Entity(name = "movie")
public class MovieEntity {

  @Id
  @GeneratedValue
  private Long id;

  private Integer rating;
  private String name;
  private String synopsis;

  @Column(name = "banner_url")
  private String banner;

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

  @OneToMany(fetch = FetchType.EAGER,mappedBy = "movieEntity")
  private Set<TrailerEntity> trailers;

  @OneToMany(fetch = FetchType.EAGER,mappedBy = "movieEntity")
  private Set<StillEntity> stills;

  @OneToOne(mappedBy = "movieEntity")
  private ExperienceEntity experienceEntity;

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

  public Set<TrailerEntity> getTrailers() {
    return trailers;
  }

  public void setTrailers(Set<TrailerEntity> trailers) {
    this.trailers = trailers;
  }

  public Set<StillEntity> getStills() {
    return stills;
  }

  public void setStills(Set<StillEntity> stills) {
    this.stills = stills;
  }

  public ExperienceEntity getExperienceEntity() {
    return experienceEntity;
  }

  public void setExperienceEntity(ExperienceEntity experienceEntity) {
    this.experienceEntity = experienceEntity;
  }

  public Integer getRating() {
    return rating;
  }

  public void setRating(Integer rating) {
    this.rating = rating;
  }

  public String getBanner() {
    return banner;
  }

  public void setBanner(String banner) {
    this.banner = banner;
  }
}
