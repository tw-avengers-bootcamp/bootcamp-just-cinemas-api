package spicinemas.api.db;

import org.springframework.data.repository.CrudRepository;
import spicinemas.api.db.entities.LocationEntity;

public interface LocationRepository  extends CrudRepository<LocationEntity,Long> {

}
