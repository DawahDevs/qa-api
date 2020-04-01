package dawahdevs.qa.api.repository;

import org.springframework.data.repository.CrudRepository;

import dawahdevs.qa.api.entity.DbUser;

public interface UserRepository extends CrudRepository<DbUser, Integer> {
}
