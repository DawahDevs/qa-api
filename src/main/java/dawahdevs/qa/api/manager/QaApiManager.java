package dawahdevs.qa.api.manager;

import org.springframework.stereotype.Service;

import dawahdevs.qa.api.entity.DbAuthor;
import dawahdevs.qa.api.entity.DbQuestion;
import dawahdevs.qa.api.entity.DbUser;
import dawahdevs.qa.api.model.AllAuthorsResponse;
import dawahdevs.qa.api.model.AllQuestionsResponse;
import dawahdevs.qa.api.model.AllUsersResponse;
import dawahdevs.qa.api.model.AuthorByIdResponse;
import dawahdevs.qa.api.model.QuestionByIdResponse;
import dawahdevs.qa.api.model.UserByIdResponse;
import dawahdevs.qa.api.repository.AuthorRepository;
import dawahdevs.qa.api.repository.QuestionRepository;
import dawahdevs.qa.api.repository.UserRepository;
import dawahdevs.qa.api.transformer.QaApiTransformer;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QaApiManager {

	private final QaApiTransformer qaApiTransformer;
	private final QuestionRepository questionRepository;
	private final UserRepository userRepository;
	private final AuthorRepository authorRepository;

	public AllQuestionsResponse getQuestions() {
		Iterable<DbQuestion> questionList = questionRepository.findAll();

		return qaApiTransformer.transformQuestionList(questionList);
	}

	public QuestionByIdResponse getQuestionById(final int questionId) {
		DbQuestion dbQuestion = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException());

		return qaApiTransformer.transformQuestionById(dbQuestion);
	}

	public AllUsersResponse getUsers() {
		Iterable<DbUser> userList = userRepository.findAll();

		return qaApiTransformer.transformUserList(userList);
	}

	public UserByIdResponse getUserById(final int userId) {
		DbUser dbUser = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());

		return qaApiTransformer.transformUserById(dbUser);
	}

	public AllAuthorsResponse getAuthors() {
		Iterable<DbAuthor> authorList = authorRepository.findAll();

		return qaApiTransformer.transformAuthorList(authorList);
	}

	public AuthorByIdResponse getAuthorById(final int authorId) {
		DbAuthor dbAuthor = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException());

		return qaApiTransformer.transformAuthorById(dbAuthor);
	}

}
