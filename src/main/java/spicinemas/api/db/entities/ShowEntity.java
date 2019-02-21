package spicinemas.api.db.entities;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity(name = "show")
public class ShowEntity {

  @Id
  @GeneratedValue
  private Long id;


  private int maxSeats;
  private int amount;
  private LocalDate showDate;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "show")
  private Set<OrderEntity> orders;

  @JoinColumn(name = "movie_location_id",foreignKey=@ForeignKey(name = "Fk_movie"))
  @OneToOne
  private MovieLocationEntity movieLocation;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }



  public int getMaxSeats() {
    return maxSeats;
  }

  public void setMaxSeats(int maxSeats) {
    this.maxSeats = maxSeats;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public LocalDate getShowDate() {
    return showDate;
  }

  public void setShowDate(LocalDate showDate) {
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
