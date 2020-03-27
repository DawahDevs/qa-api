package dawahdevs.qa.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dawahdevs.qa.api.manager.QaApiManager;
import dawahdevs.qa.api.model.AllQuestionsResponse;
import dawahdevs.qa.api.model.QuestionResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/v1/", produces = { MediaType.APPLICATION_JSON_VALUE })
public class QaApiController {

	private final QaApiManager qaApiManager;

	@GetMapping("/questions")
	public AllQuestionsResponse getAllQuestions() {
		log.info("getting all questions response");
		return qaApiManager.getAllQuestions();
	}

	@GetMapping("/questions/{questionId}")
	public QuestionResponse getQuestion(@PathVariable final int questionId) {
		log.info("getting question {} ", questionId);
		return qaApiManager.getQuestion(questionId);
	}

}