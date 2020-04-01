package dawahdevs.qa.api.repository;

import org.springframework.data.repository.CrudRepository;

import dawahdevs.qa.api.entity.DbAuthor;

public interface AuthorRepository extends CrudRepository<DbAuthor, Integer> {
}
