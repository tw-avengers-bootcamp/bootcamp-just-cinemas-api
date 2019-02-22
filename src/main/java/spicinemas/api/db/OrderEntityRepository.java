package spicinemas.api.db;


import org.springframework.data.jpa.repository.JpaRepository;
import spicinemas.api.db.entities.OrderEntity;
import spicinemas.api.db.entities.ShowEntity;

import java.util.List;

public interface OrderEntityRepository extends JpaRepository<OrderEntity,Long> {
    List<OrderEntity> findAllByShow(ShowEntity showEntity);
}
