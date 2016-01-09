package es.madhava.rentalservice.repository;

import org.springframework.data.repository.CrudRepository;

import es.madhava.rentalservice.domain.Rent;

public interface RentRepository extends CrudRepository<Rent, Long> {

}
