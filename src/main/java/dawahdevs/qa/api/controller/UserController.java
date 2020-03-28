package dawahdevs.qa.api.controller;

import dawahdevs.qa.api.entity.User;
import dawahdevs.qa.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/v1/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class UserController {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/user/{userId}")
  public @ResponseBody Optional<User> getUsers(@PathVariable final int userId) {
    log.info("getting user {}", userId);
    return userRepository.findById(userId);
  }

  @GetMapping("/users")
  public @ResponseBody Iterable<User> getUsers() {
    log.info("getting all users");
    return userRepository.findAll();
  }
}
