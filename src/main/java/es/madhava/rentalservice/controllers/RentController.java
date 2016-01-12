package es.madhava.rentalservice.controllers;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.madhava.rentalservice.domain.Film;
import es.madhava.rentalservice.domain.Rent;
import es.madhava.rentalservice.domain.User;
import es.madhava.rentalservice.points.BonusPointsCalculator;
import es.madhava.rentalservice.price.PriceCalculator;
import es.madhava.rentalservice.repository.FilmRepository;
import es.madhava.rentalservice.repository.RentRepository;
import es.madhava.rentalservice.repository.UserRepository;

@RestController
@RequestMapping("/rent")
public class RentController {

  @Autowired
  RentRepository rentRepository;
  @Autowired
  FilmRepository filmRepository;
  @Autowired
  UserRepository userRepository;

  @RequestMapping(value = "{rentId}", method = RequestMethod.GET)
  public Rent film(@PathVariable Long rentId) {
    return rentRepository.findOne(rentId);
  }

  @RequestMapping(method = RequestMethod.POST)
  public Rent create(@RequestBody Rent rent) {
    Film findOne = filmRepository.findOne(rent.getFilmId());
    Rent save = null;
    if (findOne != null) {
      Double price = PriceCalculator.getNewRentPrice(findOne.getType(), rent.getDays());
      rent.setPrice(price);
      rent.setType(findOne.getType());
      rent.setRentDay(LocalDate.now().toString());
      rent.setReturned(false);
      save = rentRepository.save(rent);
    }
    return save;
  }

  @RequestMapping(value = "{rentId}/return", method = RequestMethod.GET)
  public Map<String, Double> returnFilm(@PathVariable Long rentId) {
    Map<String, Double> result = new HashMap<>();
    Double surcharge = null;
    Rent rent = rentRepository.findOne(rentId);
    if (rent != null) {
      surcharge = getSurchargeAndReturn(rent);
      updateBonusPoints(rent);
    }
    result.put("surcharge", surcharge);
    return result;
  }

  private Double getSurchargeAndReturn(Rent rent) {
    Double surcharge;
    surcharge = PriceCalculator.getSurchargeToday(rent.getType(), rent.getRentDay(), rent.getDays());
    rent.setReturned(true);
    rentRepository.save(rent);
    return surcharge;
  }

  private void updateBonusPoints(Rent rent) {
    User user = userRepository.findOne(rent.getUserId());
    if (user != null) {
      user.setBonusPoints(user.getBonusPoints() + BonusPointsCalculator.getBonusPoints(rent.getType()));
      userRepository.save(user);
    }
  }

}
