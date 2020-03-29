package dawahdevs.qa.api.manager;

import dawahdevs.qa.api.entity.User;
import dawahdevs.qa.api.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserManager {

  private UserRepository userRepository;

  public Iterable<User> getUsers() {
    return userRepository.findAll();
  }

  public Optional<User> getUser(int userId) {
    return userRepository.findById(userId);
  }

}
