package spicinemas.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import spicinemas.api.model.Order;
import spicinemas.api.model.OrderRequest;
import spicinemas.api.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    public OrderController() {
        
    }
    
    @RequestMapping(value="/v1/order/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Order bookTicket(@RequestBody OrderRequest orderRequest) {
        Order response = orderService.createNewOrder(orderRequest.getShowId(), orderRequest.getNumberOfTickets(), orderRequest.getEmailId());

        return response;
    }
}
