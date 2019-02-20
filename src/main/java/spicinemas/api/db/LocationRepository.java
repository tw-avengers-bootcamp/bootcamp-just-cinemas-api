package spicinemas.api.db;

import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import spicinemas.api.db.entities.LocationEntity;

public interface LocationRepository  extends CrudRepository<LocationEntity,Long> {

  Set<LocationEntity> findByName(String name);

}
