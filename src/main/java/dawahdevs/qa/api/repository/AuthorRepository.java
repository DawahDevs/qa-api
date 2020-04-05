package dawahdevs.qa.api.repository;

import org.springframework.data.repository.CrudRepository;

import dawahdevs.qa.api.entity.AuthorEntity;

public interface AuthorRepository extends CrudRepository<AuthorEntity, Integer> {
}
