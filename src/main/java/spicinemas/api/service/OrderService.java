package spicinemas.api.service;

import org.hibernate.sql.ordering.antlr.OrderByAliasResolver;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import spicinemas.api.db.OrderEntityRepository;
import spicinemas.api.db.ShowRepository;
import spicinemas.api.db.entities.OrderEntity;
import spicinemas.api.db.entities.ShowEntity;
import spicinemas.api.model.Order;

import java.util.List;

@Service
public class OrderService {

    private final ShowRepository showRepository;
    private final OrderEntityRepository orderRepository;

    public OrderService(ShowRepository showRepository, OrderEntityRepository orderRepository) {
        this.showRepository = showRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public Order createNewOrder(Long showId, Long numberOfTickets, String emailId) {
        Order order = new Order();
        ShowEntity show = showRepository.findOne(showId);
        if (show != null) {
            Long maxSeats = show.getMaxSeats();
            Long bookedSeats = 0L;

            List<OrderEntity> shows = orderRepository.findAllByShow(show);

            for(OrderEntity s: shows) {
                bookedSeats += s.getSeats();
            }

            if (maxSeats - bookedSeats < numberOfTickets) {
                order.setOrderSuccess(false);
                order.setMessage("Failure in creating order as there are not enough seats;");
            }
            else {
                OrderEntity orderEntity = new OrderEntity();
                orderEntity.setEmail(emailId);
                orderEntity.setSeats(numberOfTickets);
                orderEntity.setShow(show);
                OrderEntity newOrderEntity = orderRepository.save(orderEntity);

                order.setOrderSuccess(true);
                order.setOrderId(newOrderEntity.getOrderNo());
                order.setNumberOfSeats(numberOfTickets);
                order.setEmailId(emailId);
                order.setMessage("Success");
            }
        }
        else {
            order.setMessage("Invalid combination of show selected. Cannot book tickets.");
            order.setOrderSuccess(false);
        }


        return order;

    }
}
