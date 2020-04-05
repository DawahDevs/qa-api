package dawahdevs.qa.api.repository;

import org.springframework.data.repository.CrudRepository;

import dawahdevs.qa.api.entity.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
