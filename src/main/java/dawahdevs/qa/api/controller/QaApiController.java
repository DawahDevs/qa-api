package dawahdevs.qa.api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dawahdevs.qa.api.manager.QaApiManager;
import dawahdevs.qa.api.model.AllAuthorsResponse;
import dawahdevs.qa.api.model.AllQuestionsResponse;
import dawahdevs.qa.api.model.AllUsersResponse;
import dawahdevs.qa.api.model.AuthorByIdResponse;
import dawahdevs.qa.api.model.QuestionByIdResponse;
import dawahdevs.qa.api.model.UserByIdResponse;
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
	public AllQuestionsResponse getQuestions() {
		log.info("getting all questions response");
		return qaApiManager.getQuestions();
	}

	@GetMapping("/questions/{questionId}")
	public QuestionByIdResponse getQuestionById(@PathVariable final int questionId) {
		log.info("getting question {} ", questionId);
		return qaApiManager.getQuestionById(questionId);
	}

	@GetMapping("/users")
	public AllUsersResponse getUsers() {
		log.info("getting all users");
		return qaApiManager.getUsers();
	}

	@GetMapping("/users/{userId}")
	public UserByIdResponse getUserById(@PathVariable final int userId) {
		log.info("getting user {}", userId);
		return qaApiManager.getUserById(userId);
	}

	@GetMapping("/authors")
	public AllAuthorsResponse getAuthors() {
		log.info("getting all authors");
		return qaApiManager.getAuthors();
	}

	@GetMapping("/authors/{authorId}")
	public AuthorByIdResponse getAuthorById(@PathVariable final int authorId) {
		log.info("getting author {}", authorId);
		return qaApiManager.getAuthorById(authorId);
	}
}
