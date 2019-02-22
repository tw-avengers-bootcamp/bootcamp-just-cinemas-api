package spicinemas.api.db.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ticket")
public class TicketEntity {

  @Id
  @GeneratedValue
  private Long id;

  private String ticketNo;

  private String email;

  @ManyToOne
  @JoinColumn(name="order_id")
  private OrderEntity order;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OrderEntity getOrder() { return order; }

  public void setOrder(OrderEntity order) {
    this.order = order;
  }

  public String getTicketNo() {
    return ticketNo;
  }

  public void setTicketNo(String ticketNo) {
    this.ticketNo = ticketNo;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
