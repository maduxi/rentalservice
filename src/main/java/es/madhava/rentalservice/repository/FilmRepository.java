package es.madhava.rentalservice.repository;

import org.springframework.data.repository.CrudRepository;

import es.madhava.rentalservice.domain.Film;

public interface FilmRepository extends CrudRepository<Film, Long> {

}
