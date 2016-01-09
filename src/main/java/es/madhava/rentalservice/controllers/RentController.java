package es.madhava.rentalservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.madhava.rentalservice.domain.Film;
import es.madhava.rentalservice.domain.Rent;
import es.madhava.rentalservice.price.PriceCalculator;
import es.madhava.rentalservice.repository.FilmRepository;
import es.madhava.rentalservice.repository.RentRepository;

@RestController
@RequestMapping("/rent")
public class RentController {

  @Autowired
  RentRepository rentRepository;
  @Autowired
  FilmRepository filmRepository;

  @RequestMapping(value = "{rentId}", method = RequestMethod.GET)
  public Rent film(@PathVariable Long rentId) {
    return rentRepository.findOne(rentId);
  }

  @RequestMapping(method = RequestMethod.POST)
  public Rent create(@RequestBody Rent rent) {
    Film findOne = filmRepository.findOne(rent.getFilmId());
    Rent save = null;
    if (findOne != null) {
      Double price = PriceCalculator.getPrice(findOne.getType(), rent.getDays());
      rent.setPrice(price);
      rent.setType(findOne.getType());
      save = rentRepository.save(rent);
    }
    return save;
  }

  @RequestMapping(method = RequestMethod.PUT)
  public Rent update(@RequestBody Rent rent) {
    Rent save = null;
    if (rentRepository.exists(rent.getId())) {
      Film findOne = filmRepository.findOne(rent.getFilmId());
      if (findOne != null) {
        Double price = PriceCalculator.getPrice(findOne.getType(), rent.getDays());
        rent.setPrice(price);
        rent.setType(findOne.getType());
        save = rentRepository.save(rent);
      }
    }
    return save;
  }

}
