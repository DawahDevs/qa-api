package dawahdevs.qa.api.repository;

import dawahdevs.qa.api.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
