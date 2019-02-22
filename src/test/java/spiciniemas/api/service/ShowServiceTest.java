package spiciniemas.api.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import spicinemas.api.db.*;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.db.entities.MovieLocationEntity;
import spicinemas.api.db.entities.StatusEntity;
import spicinemas.api.model.Show;
import spicinemas.api.service.ShowService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RunWith(JUnit4.class)
@ContextConfiguration(classes = ShowService.class)
public class ShowServiceTest {
    private MovieLocationRepository movieLocationRepository;
    private MoviesRepository moviesRepository;
    private LocationRepository locationRepository;
    private ShowRepository showRepository;
    private StatusRepository statusRepository;

    @Before
    public void init() {
        moviesRepository = Mockito.mock(MoviesRepository.class);
        movieLocationRepository = Mockito.mock(MovieLocationRepository.class);
        locationRepository = Mockito.mock(LocationRepository.class);
        statusRepository = Mockito.mock(StatusRepository.class);
        showRepository = Mockito.mock(ShowRepository.class);

        ShowBuilder showBuilder = ShowBuilder.getInstance();
        showBuilder.setMovieAndLocation("Kabali","testSynopsis","Chennai")
                .setOptionalAvailableSeats(200L);

        List<StatusEntity> statusEntityList = new ArrayList<>();
        StatusEntity statusEntity = new StatusEntity();
        statusEntity.setId(1L);
        statusEntity.setName("Now showing");
        statusEntityList.add(statusEntity);

        MovieBuilder builder = MovieBuilder.getInstance();
        builder.setID(1L).setMovieName("Kabaali")
                .setNewLocation(1L, "Chennai")
                .setExperience(1L, "test")
                .setLanguage(1L, "Tamil")
                .setStatus("Now showing")
                .setSynopsis("abcd synopsis");

        LocationEntity locationEntity = new LocationEntity();
        locationEntity.setId(1L);
        locationEntity.setName("Chennai");





        Mockito.when(showRepository.findOne(1L)).thenReturn(showBuilder.build());
        Mockito.when(statusRepository.findByType("Now showing")).thenReturn(statusEntityList);
        Mockito.when(moviesRepository.findOne(1L)).thenReturn(builder.build());
        Mockito.when(locationRepository.findOne(1L)).thenReturn(locationEntity);

        Iterator<MovieLocationEntity> movieLocationEntities = builder.build().getMovieLocations().iterator();

        Mockito.when(movieLocationRepository.findByLocationAndMovie(locationEntity,builder.build())).thenReturn(movieLocationEntities.next());
    }

    @Test
    public void testShowForMovie(){
        ShowService showService = new ShowService(movieLocationRepository,moviesRepository,locationRepository,showRepository,statusRepository);
        List<Show> showObj = showService.getShows(1L,"Now showing",1L);
        Assert.assertNotNull(showObj);
    }

}
