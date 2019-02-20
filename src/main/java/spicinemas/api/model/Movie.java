package spicinemas.api.model;

import lombok.EqualsAndHashCode;
import spicinemas.api.type.Status;
@EqualsAndHashCode(exclude = {"movieId"})
public class Movie {
    private Long movieId;
    private String movieName;
    private String synopsis;
    private Integer rating;
    private Status listingType;
    private Experience experience;
    private String bannerUrl;
    private Language language;


    public Movie(String name, Experience experience, Status listingType) {
        this.movieName = name;
        this.experience = experience;
        this.listingType = listingType;
    }

    public Movie() {

    }

    public Long getMovieId() {
        return movieId;
    }

    public String getMovieName() {
        return movieName;
    }

    public Experience getExperience() {
        return experience;
    }

    public Status getListingType() {
        return listingType;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setListingType(Status listingType) {
        this.listingType = listingType;
    }

    public void setExperiences(Experience experiences) {
        this.experience = experiences;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public void setLanguage(Language language) {
        this.language=language;
    }
}