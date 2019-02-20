package spicinemas.api.db;

import org.springframework.data.repository.CrudRepository;
import spicinemas.api.db.entities.StatusEntity;

public interface StatusRepository extends CrudRepository<StatusEntity,Long> {

}
