package spicinemas.api.db;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.db.entities.MovieLocationEntity;

public interface MovieLocationRepository extends JpaRepository<MovieLocationEntity,Long> {

  public List<MovieLocationEntity> findByLocation(LocationEntity locationEntity);
}
