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
  private String userId;
  private int days;

  protected Rent() {
  }

  public Rent(Long filmId, String userId, int days) {
    this.filmId = filmId;
    this.userId = userId;
    this.days = days;
  }

  public Long getId() {
    return id;
  }

  public Long getFilmId() {
    return filmId;
  }

  public String getUserId() {
    return userId;
  }

  public int getDays() {
    return days;
  }
}
