package dawahdevs.qa.api.repository;

import dawahdevs.qa.api.entity.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
