package dawahdevs.qa.api.manager;

import dawahdevs.qa.api.entity.Question;
import dawahdevs.qa.api.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
@AllArgsConstructor
public class QuestionManager {

	private final QuestionRepository questionRepository;

	public @ResponseBody
  Iterable<Question> getQuestions() {
		return questionRepository.findAll();
	}

	public @ResponseBody
  Optional<Question> getQuestion(@PathVariable final int questionId) {
		return questionRepository.findById(questionId);
	}

}
