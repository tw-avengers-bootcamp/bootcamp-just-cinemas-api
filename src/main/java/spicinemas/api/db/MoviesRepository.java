package spicinemas.api.db;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spicinemas.api.db.entities.MovieEntity;
@Repository
public interface MoviesRepository extends CrudRepository<MovieEntity,Long> {

}
