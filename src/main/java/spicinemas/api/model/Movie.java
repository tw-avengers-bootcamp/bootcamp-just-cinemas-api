package spicinemas.api.model;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(exclude = {"id"})
public class Movie {
    private Long id;
    private String name;
    private String synopsis;
    private Integer rating;
    private String experiences;
    private String bannerUrl;
    private Language language;
    private String listingType;

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
}