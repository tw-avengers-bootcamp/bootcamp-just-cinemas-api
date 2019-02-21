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
import spicinemas.api.model.Movie;
import spicinemas.api.model.Still;
import spicinemas.api.model.Trailer;
import spicinemas.api.service.MovieService;

import java.util.List;

@RunWith(JUnit4.class)
@ContextConfiguration(classes = MovieService.class)
public class MoviesServiceTest {
    private MoviesRepository moviesRepository;
    private LocationRepository locationRepository;
    private StatusRepository statusRepository;

    //TODO : Move this to builder class
    @Before
    public void init() {
        moviesRepository = Mockito.mock(MoviesRepository.class);
        locationRepository = Mockito.mock(LocationRepository.class);
        statusRepository = Mockito.mock(StatusRepository.class);

        MovieBuilder builder = MovieBuilder.getInstance();
        builder.setID(1L).setMovieName("Kabaali")
                .setNewLocation(1L, "Chennai")
                .setExperience(1L, "test")
                .setLanguage(1L, "Tamil")
                .setStatus("now showing")
                .setSynopsis("abcd synopsis")
                .setNewStill("https://www.movieposterurl.com")
                .setNewTrailer("https://www.movieposterurl.com");

        MovieBuilder noValidBuilder = MovieBuilder.getInstance();
        noValidBuilder.setID(2L).setMovieName("Kabaali")
                .setNewLocation(1L, "Chennai")
                .setExperience(1L, "test")
                .setLanguage(1L, "Tamil")
                .setStatus("now showing")
                .setSynopsis("abcd synopsis");


        Mockito.when(moviesRepository.findOne(1L)).thenReturn(builder.build());
        Mockito.when(moviesRepository.findOne(2L)).thenReturn(noValidBuilder.build());

    }

    @Test
    public void shouldTestValidMovieDetails() {

        MovieService movieService = new MovieService(moviesRepository, locationRepository, statusRepository);

        Movie movieObj = movieService.getMovieDetails(1L);
        Assert.assertNotNull(movieObj);
        Assert.assertEquals(movieObj.getName(), "Kabaali");
        Assert.assertEquals(movieObj.getSynopsis(), "abcd synopsis");
        Assert.assertEquals(movieObj.getListingType(), "now showing");
        Assert.assertEquals(movieObj.getExperiences(), "test");
    }


    @Test
    public void shouldTestInvalidMovieDetails() {
        MovieService movieService = new MovieService(moviesRepository, locationRepository, statusRepository);
        Assert.assertNotEquals(movieService.getMovieDetails(1L).getName(), "Kabali");
        Assert.assertNotEquals(movieService.getMovieDetails(1L).getSynopsis(), "some synopsis");
        Assert.assertNotEquals(movieService.getMovieDetails(1L).getExperiences(), "now showing");
    }

    @Test
    public void shouldTestMovieWithPosters() {
        MovieService movieService = new MovieService(moviesRepository, locationRepository, statusRepository);
        Movie movieObj = movieService.getMovieDetails(1L);
        Assert.assertNotNull(movieObj);
        List<Still> posters = movieObj.getStills();
        Assert.assertNotNull(posters);
        Assert.assertTrue(posters.size() > 0);
        Assert.assertEquals(posters.get(0).getUrl(), "https://www.movieposterurl.com");
    }

    @Test
    public void shouldTestMovieWithOutPosters() {
        MovieService movieService = new MovieService(moviesRepository, locationRepository, statusRepository);
        Movie movieObj = movieService.getMovieDetails(2L);
        Assert.assertNotNull(movieObj);
        List<Still> posters = movieObj.getStills();
        Assert.assertNull(posters);
    }

    @Test
    public void shouldTestMovieWithTrailer() {
        MovieService movieService = new MovieService(moviesRepository, locationRepository, statusRepository);
        Movie movieObj = movieService.getMovieDetails(1L);
        Assert.assertNotNull(movieObj);
        List<Trailer> trailers = movieObj.getTrailers();
        Assert.assertNotNull(trailers);
        Assert.assertTrue(trailers.size() > 0);
        Assert.assertEquals(trailers.get(0).getUrl(), "https://www.movieposterurl.com");
    }

    @Test
    public void shouldTestMovieWithOutTrailer() {
        MovieService movieService = new MovieService(moviesRepository, locationRepository, statusRepository);
        Movie movieObj = movieService.getMovieDetails(2L);
        Assert.assertNotNull(movieObj);
        List<Trailer> trailers = movieObj.getTrailers();
        Assert.assertNull(trailers);
    }
}
