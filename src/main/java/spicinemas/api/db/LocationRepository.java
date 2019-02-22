package spicinemas.api.db;

import java.util.List;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import spicinemas.api.db.entities.LocationEntity;

public interface LocationRepository  extends CrudRepository<LocationEntity,Long> {

  List<LocationEntity> findByName(String name);

}
