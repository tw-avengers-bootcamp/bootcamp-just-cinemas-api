package spicinemas.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.EqualsAndHashCode;
import spicinemas.api.type.MovieListingType;
@EqualsAndHashCode(exclude = {"id"})
public class Movie {
    private Long id;
    private String name;
    private String experiences;
    private String imageUrl;
    private MovieListingType listingType;

    public Movie(String name, String experiences, MovieListingType listingType) {
        this.name = name;
        this.experiences = experiences;
        this.listingType = listingType;
    }

    public Movie() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExperiences() {
        return experiences;
    }

    public MovieListingType getListingType() {
        return listingType;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}