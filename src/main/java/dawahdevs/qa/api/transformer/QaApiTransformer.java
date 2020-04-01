package dawahdevs.qa.api.transformer;

import static dawahdevs.qa.api.util.QaApiUtil.optionalMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import dawahdevs.qa.api.entity.DbAuthor;
import dawahdevs.qa.api.entity.DbQuestion;
import dawahdevs.qa.api.entity.DbUser;
import dawahdevs.qa.api.entity.Lang;
import dawahdevs.qa.api.entity.School;
import dawahdevs.qa.api.entity.Seniority;
import dawahdevs.qa.api.model.AllAuthorsResponse;
import dawahdevs.qa.api.model.AllQuestionsResponse;
import dawahdevs.qa.api.model.AllUsersResponse;
import dawahdevs.qa.api.model.Author;
import dawahdevs.qa.api.model.AuthorByIdResponse;
import dawahdevs.qa.api.model.Question;
import dawahdevs.qa.api.model.QuestionByIdResponse;
import dawahdevs.qa.api.model.User;
import dawahdevs.qa.api.model.UserByIdResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class QaApiTransformer {
	public AllQuestionsResponse transformQuestionList(final Iterable<DbQuestion> dbQuestionsList) {
		AllQuestionsResponse allQuestionsResponse = new AllQuestionsResponse();

		optionalMap(dbQuestionsList, this::extractQuestions, allQuestionsResponse::setQuestions);

		return allQuestionsResponse;
	}

	public QuestionByIdResponse transformQuestionById(final DbQuestion dbQuestion) {
		QuestionByIdResponse questionByIdResponse = new QuestionByIdResponse();

		optionalMap(dbQuestion, this::extractQuestion, questionByIdResponse::setQuestion);
		// questionByIdResponse.setAnswers(answers);
		// questionByIdResponse.setComments(comments);

		return questionByIdResponse;
	}

	public AllUsersResponse transformUserList(final Iterable<DbUser> dbUserList) {
		AllUsersResponse allUsersResponse = new AllUsersResponse();

		optionalMap(dbUserList, this::extractUsers, allUsersResponse::setUsers);

		return allUsersResponse;
	}

	public UserByIdResponse transformUserById(final DbUser dbUser) {
		UserByIdResponse userByIdResponse = new UserByIdResponse();

		optionalMap(dbUser, this::extractUser, userByIdResponse::setUser);

		return userByIdResponse;
	}

	public AllAuthorsResponse transformAuthorList(final Iterable<DbAuthor> dbAuthorList) {
		AllAuthorsResponse allAuthorsResponse = new AllAuthorsResponse();

		optionalMap(dbAuthorList, this::extractAuthors, allAuthorsResponse::setAuthors);

		return allAuthorsResponse;
	}

	public AuthorByIdResponse transformAuthorById(final DbAuthor dbAuthor) {
		AuthorByIdResponse authorByIdResponse = new AuthorByIdResponse();

		optionalMap(dbAuthor, this::extractAuthor, authorByIdResponse::setAuthor);

		return authorByIdResponse;
	}

	private List<Question> extractQuestions(final Iterable<DbQuestion> dbQuestionsList) {

		List<Question> questions = new ArrayList<>();

		dbQuestionsList.forEach(question -> questions.add(extractQuestion(question)));

		return questions;
	}

	private List<User> extractUsers(final Iterable<DbUser> dbUserList) {

		List<User> users = new ArrayList<>();

		dbUserList.forEach(user -> users.add(extractUser(user)));

		return users;
	}

	private List<Author> extractAuthors(final Iterable<DbAuthor> dbAuthorList) {

		List<Author> authors = new ArrayList<>();

		dbAuthorList.forEach(author -> authors.add(extractAuthor(author)));

		return authors;
	}

	private Question extractQuestion(final DbQuestion dbQuestion) {
		Question question = new Question();

		optionalMap(dbQuestion, DbQuestion::getText, question::setText);
		optionalMap(dbQuestion.getId(), Integer::intValue, question::setId);
		optionalMap(dbQuestion.getLang(), Lang::toString, question::setLang);
		Optional.ofNullable(dbQuestion.getUser()).map(DbUser::getId).map(Integer::intValue).ifPresent(question::setUserId);

		return question;
	}

	private User extractUser(final DbUser dbUser) {
		User user = new User();

		optionalMap(dbUser, DbUser::getName, user::setName);
		optionalMap(dbUser.getId(), Integer::intValue, user::setId);
		optionalMap(dbUser.getDefaultLang(), Lang::toString, user::setDefaultLang);

		return user;
	}

	private Author extractAuthor(final DbAuthor dbAuthor) {
		Author author = new Author();

		optionalMap(dbAuthor, DbAuthor::getName, author::setName);
		optionalMap(dbAuthor.getId(), Integer::intValue, author::setId);
		optionalMap(dbAuthor.getSchool(), School::toString, author::setSchool);
		optionalMap(dbAuthor.getSeniority(), Seniority::toString, author::setSeniority);
		optionalMap(dbAuthor.getDefaultLang(), Lang::toString, author::setDefaultLang);

		return author;
	}
}
