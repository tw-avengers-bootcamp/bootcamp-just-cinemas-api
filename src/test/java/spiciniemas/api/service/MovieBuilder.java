package spiciniemas.api.service;

import spicinemas.api.db.entities.*;

import java.util.HashSet;

public class MovieBuilder {

    private MovieBuilder() {
    }

    private MovieEntity movie = new MovieEntity();

    MovieBuilder setMovieName(String name) {
        movie.setName(name);
        return this;
    }

    MovieBuilder setSynopsis(String synopsis) {
        movie.setSynopsis(synopsis);
        return this;
    }

    MovieBuilder setID(long movie_id) {
        movie.setId(movie_id);
        return this;
    }

    public MovieBuilder setBanner(String banner) {
        movie.setBanner(banner);
        return this;
    }


    MovieBuilder setNewStill(String stillUrl) {
        if (movie.getStills() == null) {
            movie.setStills(new HashSet<>());
        }
        StillEntity stillEntity = new StillEntity();
        stillEntity.setUrl(stillUrl);
        movie.getStills().add(stillEntity);
        return this;
    }


    MovieBuilder setNewTrailer(String trailerUrl) {
        if (movie.getTrailers() == null) {
            movie.setTrailers(new HashSet<>());
        }
        TrailerEntity trailerEntity = new TrailerEntity();
        trailerEntity.setUrl(trailerUrl);
        movie.getTrailers().add(trailerEntity);
        return this;
    }

    MovieBuilder setExperience(long id, String experience) {
        ExperienceEntity experienceEntity = new ExperienceEntity();
        experienceEntity.setId(id);
        experienceEntity.setType(experience);
        movie.setExperienceEntity(experienceEntity);
        return this;
    }

    MovieBuilder setStatus(String status) {
        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setName(status);
        movie.setStatus(statusEntity);
        return this;
    }

    MovieBuilder setNewLocation(long id, String location) {
        if (movie.getLocations() == null) {
            movie.setLocations(new HashSet<>());
        }
        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setId(id);
        locationEntity.setName(location);
        movie.getLocations().add(locationEntity);
        return this;
    }

    MovieBuilder setLanguage(long id, String language) {
        LanguageEntity languageEntity = new LanguageEntity();
        languageEntity.setId(id);
        languageEntity.setName(language);
        movie.setLanguage(languageEntity);
        return this;
    }


    MovieEntity build() {
        return movie;
    }


    static MovieBuilder getInstance() {
        return new MovieBuilder();
    }
}
