package dawahdevs.qa.api.manager;

import org.springframework.stereotype.Service;

import dawahdevs.qa.api.entity.AuthorEntity;
import dawahdevs.qa.api.entity.QuestionEntity;
import dawahdevs.qa.api.entity.UserEntity;
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
		Iterable<QuestionEntity> questionList = questionRepository.findAll();

		return qaApiTransformer.transformQuestionList(questionList);
	}

	public QuestionByIdResponse getQuestionById(final int questionId) {
		QuestionEntity questionEntity = questionRepository.findById(questionId).orElseThrow(() -> new RuntimeException());

		return qaApiTransformer.transformQuestionById(questionEntity);
	}

	public AllUsersResponse getUsers() {
		Iterable<UserEntity> userList = userRepository.findAll();

		return qaApiTransformer.transformUserList(userList);
	}

	public UserByIdResponse getUserById(final int userId) {
		UserEntity userEntity = userRepository.findById(userId).orElseThrow(() -> new RuntimeException());

		return qaApiTransformer.transformUserById(userEntity);
	}

	public AllAuthorsResponse getAuthors() {
		Iterable<AuthorEntity> authorList = authorRepository.findAll();

		return qaApiTransformer.transformAuthorList(authorList);
	}

	public AuthorByIdResponse getAuthorById(final int authorId) {
		AuthorEntity authorEntity = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException());

		return qaApiTransformer.transformAuthorById(authorEntity);
	}

}
