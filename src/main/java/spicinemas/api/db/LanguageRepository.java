package spicinemas.api.db;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import spicinemas.api.db.entities.LanguageEntity;

public interface LanguageRepository  extends CrudRepository<LanguageEntity,Long> {

  public List<LanguageEntity> findByName(String name);
}
