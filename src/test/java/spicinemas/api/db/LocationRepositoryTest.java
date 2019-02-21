package spicinemas.api.db;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.db.entities.LocationEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpiCinemasApplication.class)
@ActiveProfiles("test")
public class LocationRepositoryTest {
  @Autowired
  private
  LocationRepository locationRepository;

  @Test
  public void testLocationDataIsLoaded(){
    LocationEntity locationEntity = new LocationEntity();
    locationEntity.setId(1L);
    locationEntity.setName("Chennai");
    locationRepository.save(locationEntity);

    Assert.assertNotNull(locationRepository.findOne(1L));
    Assert.assertEquals("Chennai", locationRepository.findOne(1L).getName());
  }
}
