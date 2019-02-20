package spicinemas.api.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spicinemas.api.db.LocationRepository;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.model.Location;
@Service
public class LocationService {

  private LocationRepository locationRepository;

  public LocationService(LocationRepository locationRepository) {
    this.locationRepository = locationRepository;
  }


  public List<Location> getLocations(){
    Iterable<LocationEntity> locationEntities=locationRepository.findAll();
    List<Location> locations=new ArrayList<>();
    for (LocationEntity entity:locationEntities){
      Location location = new Location();
      location.setId(entity.getId());
      location.setName(entity.getName());
      locations.add(location);
    }
    return locations;
  }

}
