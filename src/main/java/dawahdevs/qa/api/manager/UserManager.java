package dawahdevs.qa.api.manager;

import dawahdevs.qa.api.entity.User;
import dawahdevs.qa.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManager {
  private UserRepository userRepository;

  public @ResponseBody
  Optional<User> getUser(@PathVariable final int userId) {
    return userRepository.findById(userId);
  }

  public @ResponseBody
  Iterable<User> getUsers() {
    return userRepository.findAll();
  }
}
