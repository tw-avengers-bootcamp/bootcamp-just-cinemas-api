package spicinemas.api.db.entities;

import java.sql.Timestamp;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.CreationTimestamp;


@Entity(name = "show")
public class ShowEntity {

  @Id
  @GeneratedValue
  private Long id;


  private Long maxSeats;
  private Long amount;

  @Column(name = "show_date")
  @CreationTimestamp
  private Timestamp showDate;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "show")
  private Set<OrderEntity> orders;

  @JoinColumn(referencedColumnName = "id")
  @OneToOne(cascade = CascadeType.ALL)
  private MovieLocationEntity movieLocation;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }


  public Long getMaxSeats() {
    return maxSeats;
  }

  public void setMaxSeats(Long maxSeats) {
    this.maxSeats = maxSeats;
  }

  public Long getAmount() {
    return amount;
  }

  public void setAmount(Long amount) {
    this.amount = amount;
  }

  public Timestamp getShowDate() {
    return showDate;
  }

  public void setShowDate(Timestamp showDate) {
    this.showDate = showDate;
  }

  public Set<OrderEntity> getOrders() {
    return orders;
  }

  public void setOrders(Set<OrderEntity> orders) {
    this.orders = orders;
  }

  public MovieLocationEntity getMovieLocation() {
    return movieLocation;
  }

  public void setMovieLocation(MovieLocationEntity movieLocation) {
    this.movieLocation = movieLocation;
  }
}
