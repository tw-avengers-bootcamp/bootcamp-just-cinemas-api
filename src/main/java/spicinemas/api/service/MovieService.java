package spicinemas.api.service;

import org.springframework.stereotype.Service;
import spicinemas.api.db.MoviesRepository;
import spicinemas.api.db.entities.LanguageEntity;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.model.Experience;
import spicinemas.api.model.Language;
import spicinemas.api.model.Location;
import spicinemas.api.model.Movie;

import java.util.BitSet;

@Service
public class MovieService {

    private MoviesRepository moviesRepository;

    public MovieService(MoviesRepository moviesRepository) {

        this.moviesRepository = moviesRepository;
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
        Experience experience = new Experience();
        experience.setExperienceId(movieEntity.getExperienceEntity().getId());
        experience.setName(movieEntity.getExperienceEntity().getType());
        movie.setExperiences(experience);
        return movie;
    }
}
