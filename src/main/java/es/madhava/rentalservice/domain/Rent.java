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
  private Long idFilm;
  private String email;
  private int days;

  public Rent(Long idFilm, String email, int days) {
    this.idFilm = idFilm;
    this.email = email;
    this.days = days;
  }

  public Long getId() {
    return id;
  }

  public Long getIdFilm() {
    return idFilm;
  }

  public String getEmail() {
    return email;
  }

  public int getDays() {
    return days;
  }
}
