package spicinemas.api.db;

import org.springframework.data.repository.CrudRepository;
import spicinemas.api.db.entities.LanguageEntity;

public interface LanguageRepository  extends CrudRepository<LanguageEntity,Long> {



}
