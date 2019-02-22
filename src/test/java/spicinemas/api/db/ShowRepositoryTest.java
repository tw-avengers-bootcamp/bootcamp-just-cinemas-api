package spicinemas.api.db;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.db.entities.MovieLocationEntity;
import spicinemas.api.db.entities.OrderEntity;
import spicinemas.api.db.entities.ShowEntity;
import spicinemas.api.db.entities.StatusEntity;
import spicinemas.api.model.Status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class ShowRepositoryTest {

  @Autowired
  MoviesRepository moviesRepository;
  @Autowired
  LocationRepository locationRepository;
  @Autowired
  MovieLocationRepository movieLocationRepository;


  @Autowired
  ShowRepository showRepository;

  @Autowired
  OrderEntityRepository orderEntityRepository;



  @Test
  @Transactional
  public void canCreateShowAndCheckShowCreationTime() {
    ShowEntity showEntity=ShowBuilder.getInstance().build();
    ShowEntity showEntityResult=showRepository.save(showEntity);
    Assert.assertNotNull("checking is the show entity  created in db",showEntityResult.getId());
    OrderEntity orderEntity= new OrderEntity();
    orderEntity.setShow(showEntity);
    orderEntity.setOrderNo(UUID.randomUUID().toString());
    orderEntity = orderEntityRepository.save(orderEntity);

    Assert.assertNotNull(showEntityResult.getId());
    Assert.assertEquals(showEntityResult.getShowDate().toLocalDateTime().toLocalDate().atStartOfDay(),LocalDate.now().atStartOfDay());
  }

  @Test
  @Transactional
  public void testfindByMovieLocationAndStatus(){
    MovieLocationEntity movieLocationEntity=movieLocationRepository.findOne(1L);
    StatusEntity statusEntity = movieLocationEntity.getMovie().getStatus();
    ShowEntity showEntity = new ShowEntity();
    showEntity.setMovieLocation(movieLocationEntity);
    showRepository.save(showEntity);
    Assert.assertNotNull(showRepository.findByMovieLocationAndStatus(movieLocationEntity,statusEntity,Timestamp.valueOf(
        LocalDateTime.now().toLocalDate().atStartOfDay())));
  }



}
