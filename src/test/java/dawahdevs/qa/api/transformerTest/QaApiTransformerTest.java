package dawahdevs.qa.api.transformerTest;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import dawahdevs.qa.api.entity.AuthorEntity;
import dawahdevs.qa.api.entity.Lang;
import dawahdevs.qa.api.entity.QuestionEntity;
import dawahdevs.qa.api.entity.School;
import dawahdevs.qa.api.entity.Seniority;
import dawahdevs.qa.api.entity.UserEntity;
import dawahdevs.qa.api.model.AllAuthorsResponse;
import dawahdevs.qa.api.model.AllQuestionsResponse;
import dawahdevs.qa.api.model.AllUsersResponse;
import dawahdevs.qa.api.model.AuthorByIdResponse;
import dawahdevs.qa.api.model.QuestionByIdResponse;
import dawahdevs.qa.api.model.UserByIdResponse;
import dawahdevs.qa.api.transformer.QaApiTransformer;

public class QaApiTransformerTest {

	@InjectMocks
	private QaApiTransformer qaApiTransformer;

	@Before
	public void init() {
		initMocks(this);
	}

	@Test
	public void testTransformQuestionList() {
		AllQuestionsResponse allQuestionsResponse = qaApiTransformer.transformQuestionList(createDbQuestionList());

		assertEquals("Id", allQuestionsResponse.getQuestions().get(0).getId(), createDbQuestionList().get(0).getId().intValue());
		assertEquals("Text", allQuestionsResponse.getQuestions().get(0).getText(), createDbQuestionList().get(0).getText());
		assertEquals("Lang", allQuestionsResponse.getQuestions().get(0).getLang(), createDbQuestionList().get(0).getLang().toString());
		assertEquals("User Id", allQuestionsResponse.getQuestions().get(0).getUserId(), createDbQuestionList().get(0).getUser().getId().intValue());

	}

	@Test
	public void testTransformQuestionById() {
		QuestionByIdResponse questionByIdResponse = qaApiTransformer.transformQuestionById(createDbQuestion());

		assertEquals("Id", questionByIdResponse.getQuestion().getId(), createDbQuestion().getId().intValue());
		assertEquals("Text", questionByIdResponse.getQuestion().getText(), createDbQuestion().getText());
		assertEquals("Lang", questionByIdResponse.getQuestion().getLang(), createDbQuestion().getLang().toString());
		assertEquals("User Id", questionByIdResponse.getQuestion().getUserId(), createDbQuestion().getUser().getId().intValue());
	}

	@Test
	public void testTransformUserList() {
		AllUsersResponse allUsersResponse = qaApiTransformer.transformUserList(createDbUserList());

		assertEquals("Id", allUsersResponse.getUsers().get(0).getId(), createDbUserList().get(0).getId().intValue());
		assertEquals("Name", allUsersResponse.getUsers().get(0).getName(), createDbUserList().get(0).getName());
		assertEquals("Default Lang", allUsersResponse.getUsers().get(0).getDefaultLang(), createDbUserList().get(0).getDefaultLang().toString());

	}

	@Test
	public void testTransformUserById() {
		UserByIdResponse userByIdResponse = qaApiTransformer.transformUserById(createDbUser());

		assertEquals("Id", userByIdResponse.getUser().getId(), createDbUser().getId().intValue());
		assertEquals("Name", userByIdResponse.getUser().getName(), createDbUser().getName());
		assertEquals("Default Lang", userByIdResponse.getUser().getDefaultLang(), createDbUser().getDefaultLang().toString());
	}

	@Test
	public void testTransformAuthorList() {
		AllAuthorsResponse allAuthorsResponse = qaApiTransformer.transformAuthorList(createDbAuthorList());

		assertEquals("Id", allAuthorsResponse.getAuthors().get(0).getId(), createDbAuthorList().get(0).getId().intValue());
		assertEquals("Name", allAuthorsResponse.getAuthors().get(0).getName(), createDbAuthorList().get(0).getName());
		assertEquals("Default Lang", allAuthorsResponse.getAuthors().get(0).getDefaultLang(), createDbAuthorList().get(0).getDefaultLang().toString());
		assertEquals("School", allAuthorsResponse.getAuthors().get(0).getSchool(), createDbAuthorList().get(0).getSchool().toString());
		assertEquals("Seniority", allAuthorsResponse.getAuthors().get(0).getSeniority(), createDbAuthorList().get(0).getSeniority().toString());

	}

	@Test
	public void testTransformAuthorById() {
		AuthorByIdResponse authorByIdResponse = qaApiTransformer.transformAuthorById(createDbAuthor());

		assertEquals("Id", authorByIdResponse.getAuthor().getId(), createDbAuthor().getId().intValue());
		assertEquals("Name", authorByIdResponse.getAuthor().getName(), createDbAuthor().getName());
		assertEquals("Default Lang", authorByIdResponse.getAuthor().getDefaultLang(), createDbAuthor().getDefaultLang().toString());
		assertEquals("School", authorByIdResponse.getAuthor().getSchool(), createDbAuthor().getSchool().toString());
		assertEquals("Seniority", authorByIdResponse.getAuthor().getSeniority(), createDbAuthor().getSeniority().toString());
	}

	private List<QuestionEntity> createDbQuestionList() {
		List<QuestionEntity> dbQuestionList = new ArrayList<>();

		dbQuestionList.add(createDbQuestion());

		return dbQuestionList;

	}

	private List<UserEntity> createDbUserList() {
		List<UserEntity> dbUserList = new ArrayList<>();

		dbUserList.add(createDbUser());

		return dbUserList;

	}

	private List<AuthorEntity> createDbAuthorList() {
		List<AuthorEntity> dbAuthorList = new ArrayList<>();

		dbAuthorList.add(createDbAuthor());

		return dbAuthorList;

	}

	private QuestionEntity createDbQuestion() {
		QuestionEntity dbQuestion = new QuestionEntity();

		dbQuestion.setId(1);
		dbQuestion.setLang(Lang.EN);
		dbQuestion.setText("What is Islam?");
		dbQuestion.setUser(createDbUser());

		return dbQuestion;
	}

	private UserEntity createDbUser() {
		UserEntity dbUser = new UserEntity();

		dbUser.setId(1);
		dbUser.setName("Mohammad");
		dbUser.setDefaultLang(Lang.EN);

		return dbUser;
	}

	private AuthorEntity createDbAuthor() {
		AuthorEntity dbAuthor = new AuthorEntity();

		dbAuthor.setId(1);
		dbAuthor.setName("Mohammad");
		dbAuthor.setSchool(School.SHAFI);
		dbAuthor.setSeniority(Seniority.EXPERT);
		dbAuthor.setDefaultLang(Lang.EN);

		return dbAuthor;
	}

}
