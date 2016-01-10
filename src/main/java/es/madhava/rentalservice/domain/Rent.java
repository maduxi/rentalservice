package es.madhava.rentalservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Rent {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private Long filmId;
  private Long userId;
  private Long days;
  private String rentDay;
  private String type;
  private Double price;
  private boolean returned;

  protected Rent() {
  }

  public Rent(Long filmId, Long userId, String type, Long days, Double price, String rentDay) {
    this.filmId = filmId;
    this.userId = userId;
    this.days = days;
    this.type = type;
    this.price = price;
    this.rentDay = rentDay;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getFilmId() {
    return filmId;
  }

  public void setFilmId(Long filmId) {
    this.filmId = filmId;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public Long getDays() {
    return days;
  }

  public void setDays(Long days) {
    this.days = days;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getRentDay() {
    return rentDay;
  }

  public void setRentDay(String rentDay) {
    this.rentDay = rentDay;
  }

  public boolean isReturned() {
    return returned;
  }

  public void setReturned(boolean returned) {
    this.returned = returned;
  }

}
