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
import spicinemas.SpiCinemasApplication;
import spicinemas.api.db.entities.ExperienceEntity;
import spicinemas.api.db.entities.LanguageEntity;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.db.entities.StatusEntity;
import spicinemas.api.db.entities.StillEntity;
import spicinemas.api.db.entities.TrailerEntity;
import spicinemas.api.model.Language;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class MoviesRepositoryTest {

  @Autowired
  MoviesRepository moviesRepository;
  @Autowired
  LanguageRepository languageRepository;

  @Autowired
  LocationRepository locationRepository;
  @Autowired
  StatusRepository statusRepository;

  @Test
  public void testIfMovieDataLoaded(){
    Assert.assertTrue(moviesRepository.count()>0);
  }

  @Test
  public void checkStatus(){
    Assert.assertTrue(moviesRepository.findOne(1L).getStatus()!=null);
  }

  @Test
  public void checkForLocation(){

    MovieEntity movieEntity=new MovieEntity();
    LanguageEntity languageEntity =new LanguageEntity();
    movieEntity.setLanguage(languageRepository.findOne(1L));
    movieEntity.setName("test");
    movieEntity.setSynopsis("test");
    movieEntity.setLocations(new HashSet(){
      @Override
      public boolean add(Object o) {
        return this.add(locationRepository.findOne(1L));

      }
    });


    moviesRepository.save(movieEntity);
    Assert.assertTrue(moviesRepository.findOne(1L).getLocations().size()>0);
    Assert.assertTrue(moviesRepository.findOne(1L).getLocations()!=null);
  }

  @Test
  public void checkForTrailers(){
    Set<TrailerEntity> trailers=moviesRepository.findOne(1L).getTrailers();
    Assert.assertNotNull(trailers);
  }
  @Test
  public void checkForStills(){
    Set<StillEntity> stills=moviesRepository.findOne(1L).getStills();
    Assert.assertNotNull(stills);
  }

  @Test
  public void checkForExperience(){
    ExperienceEntity experienceEntity=moviesRepository.findOne(1L).getExperienceEntity();
    Assert.assertNotNull(experienceEntity);
  }

  @Test
  public void checkFindByLocationLanguageAndStatus(){

    Set<LocationEntity> locationEntities =locationRepository.findByName("Chennai");
    Assert.assertNotNull(locationEntities.size()>0);
      List<LanguageEntity> languageEntities = languageRepository.findByName("Tamil");
      Assert.assertNotNull(languageEntities.size()>0);
      LanguageEntity tamil=languageEntities.get(0);
      StatusEntity statusEntity = statusRepository.findOne(1L);
      MovieEntity movieEntity = moviesRepository.findByLocationsAndLanguageAndStatus(locationEntities,tamil, statusEntity).get(0);
      Assert.assertNotNull(movieEntity);
  }

  @Test
  public void checkFindByLocationAndStatus(){

    Set<LocationEntity> locationEntities =locationRepository.findByName("Chennai");
    Assert.assertNotNull(locationEntities.size()>0);
    List<LanguageEntity> languageEntities = languageRepository.findByName("Tamil");
    Assert.assertNotNull(languageEntities.size()>0);
    LanguageEntity tamil=languageEntities.get(0);
    StatusEntity statusEntity = statusRepository.findOne(1L);
    MovieEntity movieEntity = moviesRepository.findByLocationsAndStatus(locationEntities, statusEntity).get(0);
    Assert.assertNotNull(movieEntity);
  }
}
