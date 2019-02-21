package spicinemas.api.db;

import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.db.entities.ShowEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class ShowRepositoryTest {

  @Autowired
  MoviesRepository moviesRepository;
  @Autowired
  ShowRepository showRepository;

  @Test
  public void shouldReturnShow() {
    MovieEntity movieEntity = new MovieEntity();
    movieEntity.setName("Test Movie");
    movieEntity.setSynopsis("Sample Synopsys");
    movieEntity = moviesRepository.save(movieEntity);


  }
}
