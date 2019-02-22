package spiciniemas.api.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import spicinemas.api.db.LocationRepository;
import spicinemas.api.db.MoviesRepository;
import spicinemas.api.db.StatusRepository;
import spicinemas.api.db.entities.*;
import spicinemas.api.service.MovieService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RunWith(JUnit4.class)
@ContextConfiguration(classes = MovieService.class)
public class MoviesServiceTest {
    MoviesRepository moviesRepository;
     LocationRepository locationRepository;
     StatusRepository statusRepository;


    @Before
    public void init() {
        moviesRepository = Mockito.mock(MoviesRepository.class);
        locationRepository =Mockito.mock(LocationRepository.class);
        statusRepository=Mockito.mock(StatusRepository.class);
        Set<LocationEntity> locationEntities = new HashSet<>();
        LanguageEntity languageEntity = new LanguageEntity();
        StatusEntity statusEntity =new StatusEntity();
        LocationEntity locationEntity = new LocationEntity();
        MovieEntity movieEntity = new MovieEntity();
        ExperienceEntity experienceEntity=new ExperienceEntity();
        experienceEntity.setType("test");
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
        movieEntity.setStatus(statusEntity);
        movieEntity.setExperienceEntity(experienceEntity);

        Mockito.when(moviesRepository.findOne(1l)).thenReturn(movieEntity);

    }

    @Test
    public void shouldTestValidMovieDetails() {
        MovieService movieService = new MovieService(moviesRepository,locationRepository,statusRepository);
        Assert.assertEquals(movieService.getMovieDetails(1L).getName(),"Kabaali");
        Assert.assertEquals(movieService.getMovieDetails(1L).getSynopsis(),"abcd synopsis");
    }

    @Test
    public void shouldTestInvalidMovieDetails(){
        MovieService movieService = new MovieService(moviesRepository,locationRepository,statusRepository);
        Assert.assertNotEquals(movieService.getMovieDetails(1L).getName(),"Kabali");
        Assert.assertNotEquals(movieService.getMovieDetails(1L).getSynopsis(),"some synopsis");
    }
}
