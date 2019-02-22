package spicinemas.api.db;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.db.entities.MovieLocationEntity;
import spicinemas.api.db.entities.ShowEntity;

public interface ShowRepository extends CrudRepository<ShowEntity,Long> {
  List<ShowEntity> findByMovieLocation(MovieLocationEntity movieLocationEntity);
}
