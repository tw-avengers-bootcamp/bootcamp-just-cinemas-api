package spicinemas.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(exclude = {"id"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Movie {
    private Long id;
    private String name;
    private String synopsis;
    private Integer rating;
    private String experiences;
    private String bannerUrl;
    private Language language;
    private String listingType;
    private List<Still> stills;
    private List<Trailer> trailers;
    private String iconUrl;

    public Movie(String name, String experiences) {
        this.name = name;
        this.experiences = experiences;
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

    public void setId(Long id) {
        this.id = id;
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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setExperiences(String experiences) {
        this.experiences = experiences;
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

    public String getListingType() {
        return listingType;
    }

    public void setListingType(String listingType) {
        this.listingType = listingType;
    }

    public List<Still> getStills() {
        return stills;
    }

    public void setStills(List<Still> stills) {
        this.stills = stills;
    }

    public List<Trailer> getTrailers() {
        return trailers;
    }

    public void setTrailers(List<Trailer> trailers) {
        this.trailers = trailers;
    }

    public String getIconUrl() {
        return iconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
}