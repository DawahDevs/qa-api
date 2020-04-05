package dawahdevs.qa.api.managerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import dawahdevs.qa.api.entity.AuthorEntity;
import dawahdevs.qa.api.entity.Lang;
import dawahdevs.qa.api.entity.QuestionEntity;
import dawahdevs.qa.api.entity.School;
import dawahdevs.qa.api.entity.Seniority;
import dawahdevs.qa.api.entity.UserEntity;
import dawahdevs.qa.api.manager.QaApiManager;
import dawahdevs.qa.api.model.AllAuthorsResponse;
import dawahdevs.qa.api.model.AllQuestionsResponse;
import dawahdevs.qa.api.model.AllUsersResponse;
import dawahdevs.qa.api.model.Author;
import dawahdevs.qa.api.model.AuthorByIdResponse;
import dawahdevs.qa.api.model.Question;
import dawahdevs.qa.api.model.QuestionByIdResponse;
import dawahdevs.qa.api.model.User;
import dawahdevs.qa.api.model.UserByIdResponse;
import dawahdevs.qa.api.repository.AuthorRepository;
import dawahdevs.qa.api.repository.QuestionRepository;
import dawahdevs.qa.api.repository.UserRepository;
import dawahdevs.qa.api.transformer.QaApiTransformer;

public class QaApiManagerTest {

	@Mock
	private QaApiTransformer qaApiTransformer;

	@Mock
	private QuestionRepository questionRepository;

	@Mock
	private UserRepository userRepository;

	@Mock
	private AuthorRepository authorRepository;

	private final static Integer QUESTION_ID = 123;
	private final static Lang QUESTION_LANG = Lang.EN;
	private final static String QUESTION_TEXT = "What is Islam?";
	private final static Integer USER_ID = 456;
	private final static Lang USER_DEFAULT_LANG = Lang.EN;
	private final static String USER_NAME = "Mohammad";
	private final static Integer AUTHOR_ID = 456;
	private final static String AUTHOR_NAME = "Ali";
	private final static Lang AUTHOR_DEFAULT_LANG = Lang.EN;
	private final static School AUTHOR_SCHOOL = School.SHAFI;
	private final static Seniority AUTHOR_SENIORITY = Seniority.EXPERT;

	@InjectMocks
	private QaApiManager qaApiManager;

	@Before
	public void init() {
		qaApiTransformer = new QaApiTransformer();
		initMocks(this);

	}

	@Test
	public void testGetQuestions() {
		when(questionRepository.findAll()).thenReturn(Collections.singletonList(createDbQuestion()));
		when(qaApiTransformer.transformQuestionList(any())).thenReturn(createAllQuestionsResponse());

		AllQuestionsResponse allQuestionsResponse = qaApiManager.getQuestions();

		assertEquals("Id", allQuestionsResponse.getQuestions().get(0).getId(), createDbQuestion().getId().intValue());
		assertEquals("Lang", allQuestionsResponse.getQuestions().get(0).getLang(), createDbQuestion().getLang().toString());
		assertEquals("Text", allQuestionsResponse.getQuestions().get(0).getText(), createDbQuestion().getText());
		assertEquals("User Id", allQuestionsResponse.getQuestions().get(0).getUserId(), createDbQuestion().getUser().getId().intValue());

	}

	@Test
	public void testGetQuestionById() {
		when(questionRepository.findById(any())).thenReturn(Optional.of(createDbQuestion()));
		when(qaApiTransformer.transformQuestionById(any(QuestionEntity.class))).thenReturn(createQuestionByIdResponse());

		QuestionByIdResponse questionByIdResponse = qaApiManager.getQuestionById(QUESTION_ID.intValue());

		assertEquals("Id", questionByIdResponse.getQuestion().getId(), createDbQuestion().getId().intValue());
		assertEquals("Lang", questionByIdResponse.getQuestion().getLang(), createDbQuestion().getLang().toString());
		assertEquals("Text", questionByIdResponse.getQuestion().getText(), createDbQuestion().getText());
		assertEquals("User Id", questionByIdResponse.getQuestion().getUserId(), createDbQuestion().getUser().getId().intValue());
	}

	@Test(expected = RuntimeException.class)
	public void testGetQuestionByIdNotFound() {
		when(questionRepository.findById(any())).thenReturn(null);

		QuestionByIdResponse questionByIdResponse = qaApiManager.getQuestionById(QUESTION_ID.intValue());

		verify(qaApiManager, times(1)).getQuestionById(QUESTION_ID.intValue());

	}

	@Test
	public void testGetUsers() {
		when(userRepository.findAll()).thenReturn(Collections.singletonList(createDbUser()));
		when(qaApiTransformer.transformUserList(any())).thenReturn(createAllUsersResponse());

		AllUsersResponse allUsersResponse = qaApiManager.getUsers();

		assertEquals("Id", allUsersResponse.getUsers().get(0).getId(), createDbUser().getId().intValue());
		assertEquals("Default Lang", allUsersResponse.getUsers().get(0).getDefaultLang(), createDbUser().getDefaultLang().toString());
		assertEquals("Name", allUsersResponse.getUsers().get(0).getName(), createDbUser().getName());
	}

	@Test
	public void testGetUserById() {
		when(userRepository.findById(any())).thenReturn(Optional.of(createDbUser()));
		when(qaApiTransformer.transformUserById(any(UserEntity.class))).thenReturn(createUserByIdResponse());

		UserByIdResponse userByIdResponse = qaApiManager.getUserById(USER_ID.intValue());

		assertEquals("Id", userByIdResponse.getUser().getId(), createDbUser().getId().intValue());
		assertEquals("Default Lang", userByIdResponse.getUser().getDefaultLang(), createDbUser().getDefaultLang().toString());
		assertEquals("Name", userByIdResponse.getUser().getName(), createDbUser().getName());
	}

	@Test(expected = RuntimeException.class)
	public void testGetUserByIdNotFound() {
		when(userRepository.findById(any())).thenReturn(null);

		UserByIdResponse userByIdResponse = qaApiManager.getUserById(USER_ID.intValue());

		verify(qaApiManager, times(1)).getUserById(USER_ID.intValue());
	}

	@Test
	public void testGetAuthors() {
		when(authorRepository.findAll()).thenReturn(Collections.singletonList(createDbAuthor()));
		when(qaApiTransformer.transformAuthorList(any())).thenReturn(createAllAuthorsResponse());

		AllAuthorsResponse allAuthorsResponse = qaApiManager.getAuthors();

		assertEquals("Id", allAuthorsResponse.getAuthors().get(0).getId(), createDbAuthor().getId().intValue());
		assertEquals("Default Lang", allAuthorsResponse.getAuthors().get(0).getDefaultLang(), createDbAuthor().getDefaultLang().toString());
		assertEquals("Name", allAuthorsResponse.getAuthors().get(0).getName(), createDbAuthor().getName());
		assertEquals("School", allAuthorsResponse.getAuthors().get(0).getSchool(), createDbAuthor().getSchool().toString());
		assertEquals("Seniority", allAuthorsResponse.getAuthors().get(0).getSeniority(), createDbAuthor().getSeniority().toString());

	}

	@Test
	public void testGetAuthorById() {
		when(authorRepository.findById(any())).thenReturn(Optional.of(createDbAuthor()));
		when(qaApiTransformer.transformAuthorById(any(AuthorEntity.class))).thenReturn(createAuthorByIdResponse());

		AuthorByIdResponse authorByIdResponse = qaApiManager.getAuthorById(AUTHOR_ID.intValue());

		assertEquals("Id", authorByIdResponse.getAuthor().getId(), createDbAuthor().getId().intValue());
		assertEquals("Default Lang", authorByIdResponse.getAuthor().getDefaultLang(), createDbAuthor().getDefaultLang().toString());
		assertEquals("Name", authorByIdResponse.getAuthor().getName(), createDbAuthor().getName());
		assertEquals("School", authorByIdResponse.getAuthor().getSchool(), createDbAuthor().getSchool().toString());
		assertEquals("Seniority", authorByIdResponse.getAuthor().getSeniority(), createDbAuthor().getSeniority().toString());
	}

	@Test(expected = RuntimeException.class)
	public void testGetAuthorByIdNotFound() {
		when(authorRepository.findById(any())).thenReturn(null);

		AuthorByIdResponse authorByIdResponse = qaApiManager.getAuthorById(AUTHOR_ID.intValue());

		verify(qaApiManager, times(1)).getAuthorById(AUTHOR_ID.intValue());

	}

	private QuestionEntity createDbQuestion() {
		QuestionEntity dbQuestion = new QuestionEntity();

		dbQuestion.setId(QUESTION_ID);
		dbQuestion.setLang(QUESTION_LANG);
		dbQuestion.setText(QUESTION_TEXT);
		dbQuestion.setUser(createDbUser());

		return dbQuestion;
	}

	private UserEntity createDbUser() {
		UserEntity dbUser = new UserEntity();

		dbUser.setId(USER_ID);
		dbUser.setDefaultLang(USER_DEFAULT_LANG);
		dbUser.setName(USER_NAME);

		return dbUser;
	}

	private AuthorEntity createDbAuthor() {
		AuthorEntity dbAuthor = new AuthorEntity();

		dbAuthor.setId(AUTHOR_ID);
		dbAuthor.setName(AUTHOR_NAME);
		dbAuthor.setDefaultLang(AUTHOR_DEFAULT_LANG);
		dbAuthor.setSchool(AUTHOR_SCHOOL);
		dbAuthor.setSeniority(AUTHOR_SENIORITY);

		return dbAuthor;
	}

	private AllQuestionsResponse createAllQuestionsResponse() {
		AllQuestionsResponse allQuestionsResponse = new AllQuestionsResponse();

		allQuestionsResponse.setQuestions(createQuestionList());

		return allQuestionsResponse;
	}

	private QuestionByIdResponse createQuestionByIdResponse() {
		QuestionByIdResponse questionByIdResponse = new QuestionByIdResponse();

		questionByIdResponse.setQuestion(createQuestion());

		return questionByIdResponse;
	}

	private AllUsersResponse createAllUsersResponse() {
		AllUsersResponse allUsersResponse = new AllUsersResponse();

		allUsersResponse.setUsers(createUserList());

		return allUsersResponse;
	}

	private UserByIdResponse createUserByIdResponse() {

		UserByIdResponse userByIdResponse = new UserByIdResponse();

		userByIdResponse.setUser(createUser());

		return userByIdResponse;
	}

	private AllAuthorsResponse createAllAuthorsResponse() {
		AllAuthorsResponse allAuthorsResponse = new AllAuthorsResponse();

		allAuthorsResponse.setAuthors(createAuthorList());

		return allAuthorsResponse;
	}

	private AuthorByIdResponse createAuthorByIdResponse() {

		AuthorByIdResponse authorByIdResponse = new AuthorByIdResponse();

		authorByIdResponse.setAuthor(createAuthor());

		return authorByIdResponse;
	}

	private List<Question> createQuestionList() {
		List<Question> questionList = new ArrayList<>();

		questionList.add(createQuestion());

		return questionList;
	}

	private List<User> createUserList() {
		List<User> userList = new ArrayList<>();

		userList.add(createUser());

		return userList;
	}

	private List<Author> createAuthorList() {
		List<Author> authorList = new ArrayList<>();

		authorList.add(createAuthor());

		return authorList;
	}

	private Question createQuestion() {
		Question question = new Question();

		question.setId(QUESTION_ID.intValue());
		question.setLang(QUESTION_LANG.toString());
		question.setText(QUESTION_TEXT);
		question.setUserId(createDbUser().getId());

		return question;
	}

	private User createUser() {
		User user = new User();

		user.setId(USER_ID);
		user.setDefaultLang(USER_DEFAULT_LANG.toString());
		user.setName(USER_NAME);

		return user;
	}

	private Author createAuthor() {
		Author author = new Author();

		author.setId(AUTHOR_ID);
		author.setName(AUTHOR_NAME);
		author.setDefaultLang(AUTHOR_DEFAULT_LANG.toString());
		author.setSchool(AUTHOR_SCHOOL.toString());
		author.setSeniority(AUTHOR_SENIORITY.toString());

		return author;
	}

}
