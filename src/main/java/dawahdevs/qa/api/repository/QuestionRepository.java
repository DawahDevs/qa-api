package dawahdevs.qa.api.repository;

import org.springframework.data.repository.CrudRepository;

import dawahdevs.qa.api.entity.QuestionEntity;

public interface QuestionRepository extends CrudRepository<QuestionEntity, Integer> {
}
