package dawahdevs.qa.api.repository;

import org.springframework.data.repository.CrudRepository;

import dawahdevs.qa.api.entity.DbQuestion;

public interface QuestionRepository extends CrudRepository<DbQuestion, Integer> {
}
