package spicinemas.api.db.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "status")
public class StatusEntity {

  @Id
  @GeneratedValue
  private Long id;
  private String type;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return type;
  }

  public void setName(String name) {
    this.type = name;
  }
}
