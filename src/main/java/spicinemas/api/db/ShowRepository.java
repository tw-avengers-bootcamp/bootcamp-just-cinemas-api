package spicinemas.api.db;

import java.sql.Timestamp;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import spicinemas.api.db.entities.MovieEntity;
import spicinemas.api.db.entities.MovieLocationEntity;
import spicinemas.api.db.entities.ShowEntity;
import spicinemas.api.db.entities.StatusEntity;

public interface ShowRepository extends CrudRepository<ShowEntity,Long> {

  @Query("Select s from  show as s , movielocation as  ml , movie as m "
      + "where ml.movie = m  and "
      + "m.status = :status and "
      + "s.movieLocation = ml and "
      + "s.movieLocation = :movielocation  and s.showDate >= :date")
  List<ShowEntity> findByMovieLocationAndStatus(@Param("movielocation") MovieLocationEntity movieLocationEntity,@Param("status")
      StatusEntity statusEntity , @Param("date") Timestamp date);
}

/**
  Select s from  spicinemas.api.db.entities.ShowEntity as s ,
    spicinemas.api.db.entities.MovieLocationEntity as  ml ,
    spicinemas.api.db.entities.MovieEntity m
    where ml.movie = m
    m.status = :status
    and s.movielocation = ml
    s.movielocation = :movielocation

 **/

/**

 Select s from  spicinemas.api.db.entities.ShowEntity as s , spicinemas.api.db.entities.MovieLocationEntity as  ml , spicinemas.api.db.entities.MovieEntity as m where ml.movie = m  and m.status = :status and s.movieLocation = ml s.movieLocation = :movielocation ]
 at org.hibernate.hql.internal.ast.QuerySyntaxException.convert(QuerySyntaxException.java:74) ~[hibernate-core-5.0.11.Final.jar:5.0.11.Final
 **/