package es.madhava.rentalservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.madhava.rentalservice.domain.Film;
import es.madhava.rentalservice.repository.FilmRepository;

@RestController
@RequestMapping("/film")
public class FilmController {

  @Autowired
  FilmRepository filmRepository;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<Film> films() {
    return filmRepository.findAll();
  }

  @RequestMapping(value = "{filmId}", method = RequestMethod.GET)
  public Film film(@PathVariable Long filmId) {
    return filmRepository.findOne(filmId);
  }

  @RequestMapping(method = RequestMethod.POST)
  public Film create(@RequestBody Film name) {
    return filmRepository.save(name);
  }
}
