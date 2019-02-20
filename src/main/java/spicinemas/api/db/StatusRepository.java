package spicinemas.api.db;

import org.springframework.data.repository.CrudRepository;
import spicinemas.api.db.entities.StatusEntity;
import spicinemas.api.type.Status;

import java.util.List;

public interface StatusRepository extends CrudRepository<StatusEntity,Long> {

    public List<StatusEntity> findByType(String type);

}
