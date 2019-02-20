package spicinemas.api.service;

import org.springframework.stereotype.Service;

import spicinemas.api.db.LocationRepository;
import spicinemas.api.db.MoviesRepository;
import spicinemas.api.db.StatusRepository;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.db.entities.StatusEntity;
import spicinemas.api.model.Experience;
import spicinemas.api.model.Language;
import spicinemas.api.model.Movie;

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
        movie.setMovieId(movieEntity.getId());
        movie.setMovieName(movieEntity.getName());
        movie.setSynopsis(movieEntity.getSynopsis());
        //LanguageEntity languageEntity = movieEntity.getLanguage();
        Language language = new Language();
        language.setLanguage(movieEntity.getLanguage().getName());
        movie.setLanguage(language);
        movie.setExperiences(movieEntity.getExperienceEntity().getType());
        return movie;

    }

    public List<Movie> getMoviesByLocationAndStatus(Long locationId, String statusName) {
        LocationEntity location = locationRepository.findOne(locationId);
        StatusEntity status = statusRepository.findOne(1L);
        Set<LocationEntity> locationSet = new HashSet<>();
        locationSet.add(location);
        List<MovieEntity> movieEntities = moviesRepository.findByLocationsAndStatus(locationSet, status);

        return movieEntities.stream().map((m) -> {
           Movie movie = new Movie();
           movie.setMovieName(m.getName());
           movie.setMovieId(m.getId());
           movie.setSynopsis(m.getSynopsis());
           movie.setRating(m.getRating());
           movie.setBannerUrl(m.getBanner());
           movie.setExperiences(m.getExperienceEntity().getType());

           return movie;
        }).collect(Collectors.toList());
    }
}
