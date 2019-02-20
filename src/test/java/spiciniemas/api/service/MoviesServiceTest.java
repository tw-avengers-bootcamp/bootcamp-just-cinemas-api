package spiciniemas.api.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import spicinemas.api.db.MoviesRepository;
import spicinemas.api.db.entities.LanguageEntity;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.db.entities.StatusEntity;
import spicinemas.api.service.MovieService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RunWith(JUnit4.class)
@ContextConfiguration(classes = MovieService.class)
public class MoviesServiceTest {
    MoviesRepository moviesRepository;

    @Before
    public void init() {
        moviesRepository = Mockito.mock(MoviesRepository.class);
        Set<LocationEntity> locationEntities = new HashSet<>();
        LanguageEntity languageEntity = Mockito.mock(LanguageEntity.class);
        StatusEntity statusEntity = Mockito.mock(StatusEntity.class);
        LocationEntity locationEntity = new LocationEntity();
        MovieEntity movieEntity = Mockito.mock(MovieEntity.class);
        languageEntity.setId(1l);
        languageEntity.setName("Tamil");
        statusEntity.setId(1l);
        statusEntity.setName("now showing");
        locationEntity.setId(1l);
        locationEntity.setName("Chennai");
        locationEntities.add(locationEntity);

        movieEntity.setId(1l);
        movieEntity.setSynopsis("abcd synopsis");
        movieEntity.setName("Kabaali");
        movieEntity.setLanguage(languageEntity);
        movieEntity.setLocations(locationEntities);
        movieEntity.setStatus(statusEntity);

        Mockito.when(moviesRepository.findOne(1l)).thenReturn(movieEntity);

    }

    @Test
    public void testGetMovieDetails() {
        MovieService movieService = new MovieService(moviesRepository);
        Assert.assertNotNull(movieService.getMovieDetails(1l));

    }
}
