package spicinemas.api.db;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.db.entities.ExperienceEntity;
import spicinemas.api.db.entities.LanguageEntity;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.db.entities.MovieLocationEntity;
import spicinemas.api.db.entities.StatusEntity;
import spicinemas.api.db.entities.StillEntity;
import spicinemas.api.db.entities.TrailerEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class MoviesRepositoryTest {

  @Autowired
  private
  MoviesRepository moviesRepository;
  @Autowired
  private
  LanguageRepository languageRepository;

  @Autowired
  private
  LocationRepository locationRepository;
  @Autowired
  private
  StatusRepository statusRepository;

  @Autowired
  MovieLocationRepository movieLocationRepository;

  @Test
  public void testIfMovieDataLoaded() {
    Assert.assertTrue(moviesRepository.count() > 0);
  }

  @Test
  public void checkStatus(){
    Assert.assertNotNull(moviesRepository.findOne(1L));
    Assert.assertEquals(moviesRepository.findOne(1L).getStatus().getName(),"now showing");
  }

  @Test
  @Transactional
  public void checkForLocation() {

    Set<MovieLocationEntity> locationEntity = new HashSet<>();
    locationEntity.add(movieLocationRepository.findOne(1L));

    MovieEntity movieEntity=new MovieEntity();
    movieEntity.setLanguage(languageRepository.findOne(1L));
    movieEntity.setName("test");
    movieEntity.setSynopsis("test");
    movieEntity.setLocations(locationEntity);
    movieEntity.setLocations(locationEntity);
    moviesRepository.save(movieEntity);
    Assert.assertNotNull(moviesRepository.findOne(1L).getMovieLocations());
    Assert.assertTrue(moviesRepository.findOne(1L).getMovieLocations().size()>0);
  }

  @Test
  public void checkForTrailers() {
    Set<TrailerEntity> trailers = moviesRepository.findOne(1L).getTrailers();
    Assert.assertNotNull(trailers);
  }

  @Test
  public void checkForStills() {
    Set<StillEntity> stills = moviesRepository.findOne(1L).getStills();
    Assert.assertNotNull(stills);
  }

  @Test
  public void checkForExperience() {
    ExperienceEntity experienceEntity = moviesRepository.findOne(1L).getExperienceEntity();
    Assert.assertNotNull(experienceEntity);
  }


  @Test
  public void checkFindByLocationAndStatus(){
    List<LocationEntity> locationEntities = locationRepository.findByName("Chennai");
    Assert.assertNotNull(locationEntities.size() > 0);
    List<LanguageEntity> languageEntities = languageRepository.findByName("Tamil");
    Assert.assertNotNull(languageEntities.size() > 0);
    LanguageEntity tamil = languageEntities.get(0);
    StatusEntity statusEntity = statusRepository.findOne(1L);
    MovieEntity movieEntity = moviesRepository
        .findByMovieLocationsAndStatus(locationEntities.get(0), statusEntity).get(0);
    Assert.assertNotNull(movieEntity);
  }
}
