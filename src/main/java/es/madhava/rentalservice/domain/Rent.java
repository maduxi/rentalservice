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
  private int days;
  private String type;
  private Double price;

  protected Rent() {
  }

  public Rent(Long filmId, Long userId, String type, int days, Double price) {
    this.filmId = filmId;
    this.userId = userId;
    this.days = days;
    this.type = type;
    this.price = price;
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

  public int getDays() {
    return days;
  }

  public void setDays(int days) {
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

}
