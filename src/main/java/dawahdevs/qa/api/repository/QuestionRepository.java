package dawahdevs.qa.api.repository;

import dawahdevs.qa.api.entity.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
}
