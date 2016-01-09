package es.madhava.rentalservice.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.madhava.rentalservice.domain.User;
import es.madhava.rentalservice.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserRepository userRepository;

  @RequestMapping(method = RequestMethod.GET)
  public Iterable<User> films() {
    return userRepository.findAll();
  }

  @RequestMapping(value = "{userId}", method = RequestMethod.GET)
  public User film(@PathVariable Long userId) {
    return userRepository.findOne(userId);
  }

  @RequestMapping(method = RequestMethod.POST)
  public User create(@RequestBody User name) {
    return userRepository.save(name);
  }
}
