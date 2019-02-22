package spicinemas.api.db.entities;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Entity(name = "orders")
public class OrderEntity {
  @Id
  @GeneratedValue
  private Long id;

  @ManyToOne
  @JoinColumn(name="show_id")
  private ShowEntity show;
  private Long seats;
  private String email;
  @Column(name="order_date")
  @CreationTimestamp
  private Timestamp orderDate;


  @GenericGenerator(name = "uuid", strategy = "uuid2")
  @GeneratedValue(generator = "uuid")
  private String orderNo;


  public Long getSeats() {
    return seats;
  }

  public void setSeats(Long seats) {
    this.seats = seats;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Timestamp getOrderDate() {
    return orderDate;
  }

  public void setOrderDate(Timestamp orderDate) {
    this.orderDate = orderDate;
  }

  public ShowEntity getShow() {
    return show;
  }

  public void setShow(ShowEntity show) {
    this.show = show;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getOrderNo() {
    return orderNo;
  }

  public void setOrderNo(String orderNo) {
    this.orderNo = orderNo;
  }
}
