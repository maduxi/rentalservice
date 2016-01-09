package es.madhava.rentalservice.repository;

import org.springframework.data.repository.CrudRepository;

import es.madhava.rentalservice.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
