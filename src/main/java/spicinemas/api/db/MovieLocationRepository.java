package spicinemas.api.db;

import org.springframework.data.jpa.repository.JpaRepository;
import spicinemas.api.db.entities.MovieLocationEntity;

public interface MovieLocationRepository extends JpaRepository<MovieLocationEntity,Long> {

}
