package spicinemas.api.db;

import java.util.HashSet;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.db.entities.LanguageEntity;
import spicinemas.api.db.entities.MovieEntity;
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
}
