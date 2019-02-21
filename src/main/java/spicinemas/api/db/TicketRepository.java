package spicinemas.api.db;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import spicinemas.api.db.entities.OrderEntity;
import spicinemas.api.db.entities.TicketEntity;

public interface TicketRepository extends CrudRepository<TicketEntity,Long> {
  List<TicketEntity> findByOrder(OrderEntity orderEntity);
}
