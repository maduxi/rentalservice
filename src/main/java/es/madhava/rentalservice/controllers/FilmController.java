package es.madhava.rentalservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.madhava.rentalservice.domain.Film;
import es.madhava.rentalservice.repository.FilmRepository;

@RestController
public class FilmController {

  @Autowired
  FilmRepository filmRepository;

  @RequestMapping("/film")
  public Iterable<Film> films(@RequestParam(value = "name", defaultValue = "World") String name) {
    return filmRepository.findAll();
  }

  @RequestMapping(value = "/film", method = RequestMethod.POST)
  public Film create(@RequestBody Film name) {
    return filmRepository.save(name);
  }
}
