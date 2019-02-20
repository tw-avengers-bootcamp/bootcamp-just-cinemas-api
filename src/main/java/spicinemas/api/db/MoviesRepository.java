package spicinemas.api.db;


import java.util.List;
import java.util.Set;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spicinemas.api.db.entities.LanguageEntity;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.db.entities.StatusEntity;
import spicinemas.api.model.Language;
import spicinemas.api.model.Status;

@Repository
public interface MoviesRepository extends CrudRepository<MovieEntity,Long> {

  public List<MovieEntity> findByLocationsAndLanguageAndStatus(Set<LocationEntity> locations, LanguageEntity language,StatusEntity status);

}
