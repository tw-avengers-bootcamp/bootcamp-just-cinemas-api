package spicinemas.api.db;


import org.springframework.data.jpa.repository.JpaRepository;
import spicinemas.api.db.entities.OrderEntity;

public interface OrderEntityRepository extends JpaRepository<OrderEntity,Long> {

}
