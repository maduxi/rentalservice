package es.madhava.rentalservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.madhava.rentalservice.domain.Rent;
import es.madhava.rentalservice.repository.RentRepository;

@RestController
@RequestMapping("/rent")
public class RentController {

  @Autowired
  RentRepository rentRepository;

  @RequestMapping(value = "{rentId}", method = RequestMethod.GET)
  public Rent film(@PathVariable Long rentId) {
    return rentRepository.findOne(rentId);
  }

  @RequestMapping(value = "/rent", method = RequestMethod.POST)
  public Rent create(@RequestBody Rent name) {
    return rentRepository.save(name);
  }

}
