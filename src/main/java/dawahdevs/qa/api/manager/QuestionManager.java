package dawahdevs.qa.api.manager;

import dawahdevs.qa.api.entity.Question;
import dawahdevs.qa.api.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionManager {

  private final QuestionRepository questionRepository;

  public Iterable<Question> getQuestions() {
    return questionRepository.findAll();
  }

  public Optional<Question> getQuestion(int questionId) {
    return questionRepository.findById(questionId);
  }

}
