package spicinemas.api.db;

import java.sql.Timestamp;
import java.time.LocalDate;
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


}
