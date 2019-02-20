package spiciniemas.api.service;


import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import spicinemas.SpiCinemasApplication;
import spicinemas.api.db.LocationRepository;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.service.LocationService;

@RunWith(JUnit4.class)
@ContextConfiguration(classes = LocationService.class)
public class LocationServiceTest {



  LocationRepository locationRepository;



  @Before
  public void init() {
    locationRepository= Mockito.mock(LocationRepository.class);
    ArrayList<LocationEntity> locationEntities=new ArrayList<>();
    LocationEntity locationEntity=new LocationEntity();
    locationEntity.setId(1L);
    locationEntity.setName("test location");
    locationEntities.add(locationEntity);
    Mockito.when(locationRepository.findAll()).thenReturn(locationEntities);
  }

  @Test
    public void testGetLocations(){

    LocationService locationService=new LocationService(locationRepository);
    Assert.assertNotNull(locationService.getLocations().size()>0);
    }
}
