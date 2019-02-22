package spicinemas.api.db;


import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spicinemas.api.db.entities.LanguageEntity;
import spicinemas.api.db.entities.LocationEntity;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.db.entities.MovieLocationEntity;
import spicinemas.api.db.entities.StatusEntity;
import spicinemas.api.model.Language;
import spicinemas.api.model.Status;

@Repository
public interface MoviesRepository extends JpaRepository<MovieEntity,Long> {

  @Query("Select m from  movie as m , movielocation as  ml , location as l , status as s "
      + "where ml.movie = m and "
      + "ml.location = l and "
      + "ml.location = :location and "
      + "m.status = s and "
      + "s = :status")
  public List<MovieEntity> findByMovieLocationsAndStatus(@Param("location") LocationEntity location,@Param("status") StatusEntity status);

}
