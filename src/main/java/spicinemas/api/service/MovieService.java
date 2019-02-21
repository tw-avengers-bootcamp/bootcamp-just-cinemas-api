package spicinemas.api.service;

import org.springframework.stereotype.Service;

import spicinemas.api.db.LocationRepository;
import spicinemas.api.db.MoviesRepository;
import spicinemas.api.db.StatusRepository;
import spicinemas.api.db.entities.*;
import spicinemas.api.model.Language;
import spicinemas.api.model.Movie;
import spicinemas.api.model.Still;
import spicinemas.api.model.Trailer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final MoviesRepository moviesRepository;
    private LocationRepository locationRepository;
    private StatusRepository statusRepository;


    public MovieService(MoviesRepository moviesRepository, LocationRepository locationRepository, StatusRepository statusRepository) {
        this.moviesRepository = moviesRepository;
        this.locationRepository = locationRepository;
        this.statusRepository = statusRepository;
    }

    public Movie getMovieDetails(long movie_id) {
        MovieEntity movieEntity = moviesRepository.findOne(movie_id);
        Movie movie = new Movie();
        movie.setId(movieEntity.getId());
        movie.setName(movieEntity.getName());
        movie.setSynopsis(movieEntity.getSynopsis());
        movie.setRating(movieEntity.getRating());
        movie.setBannerUrl(movieEntity.getBanner());
        Language language = new Language();
        language.setLanguage(movieEntity.getLanguage().getName());
        movie.setLanguage(language);
        mapTrailerData(movie,movieEntity);
        mapStillData(movie,movieEntity);
        movie.setExperiences(movieEntity.getExperienceEntity().getType());
        movie.setListingType(movieEntity.getStatus().getName());
        return movie;

    }

    private void mapStillData(Movie movie, MovieEntity movieEntity) {
       if(movieEntity.getStills()!=null){
           List<Still> stills = new ArrayList<>();
           for (StillEntity stillEntity:movieEntity.getStills()){
               Still still = new Still();
               still.setUrl(stillEntity.getUrl());
               stills.add(still);
           }
           movie.setStills(stills);
       }
    }

    private void mapTrailerData(Movie movie, MovieEntity movieEntity) {
        if(movieEntity.getTrailers()!=null){
            List<Trailer> trailers = new ArrayList<>();
            for(TrailerEntity trailerEntity:movieEntity.getTrailers()){
                Trailer trailer = new Trailer();
                trailer.setUrl(trailerEntity.getUrl());
                trailers.add(trailer);
            }
            movie.setTrailers(trailers);
        }
    }

    public List<Movie> getMoviesByLocationAndStatus(Long locationId, String statusName) {
        LocationEntity location = locationRepository.findOne(locationId);
        StatusEntity status = statusRepository.findOne(1L);
        Set<LocationEntity> locationSet = new HashSet<>();
        locationSet.add(location);
        List<MovieEntity> movieEntities = moviesRepository.findByLocationsAndStatus(locationSet, status);

        return movieEntities.stream().map((m) -> {
           Movie movie = new Movie();
           movie.setName(m.getName());
           movie.setId(m.getId());
           movie.setSynopsis(m.getSynopsis());
           movie.setRating(m.getRating());
           movie.setBannerUrl(m.getBanner());
           movie.setExperiences(m.getExperienceEntity().getType());
           movie.setListingType(m.getStatus().getName());

           return movie;
        }).collect(Collectors.toList());
    }
}
