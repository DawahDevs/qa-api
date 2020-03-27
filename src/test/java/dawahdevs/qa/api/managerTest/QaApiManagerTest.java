package dawahdevs.qa.api.managerTest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import dawahdevs.qa.api.config.Config;
import dawahdevs.qa.api.dao.QaApiDAO;
import dawahdevs.qa.api.manager.QaApiManager;
import dawahdevs.qa.api.model.AllQuestionsBackendResponse;
import dawahdevs.qa.api.model.AllQuestionsResponse;
import dawahdevs.qa.api.model.QuestionBackendResponse;
import dawahdevs.qa.api.model.QuestionResponse;
import dawahdevs.qa.api.transformer.QaApiTransformer;
import dawahdevs.qa.api.validator.QaApiValidator;

public class QaApiManagerTest {

	@Mock
	private QaApiTransformer qaApiTransformer;

	@Mock
	private QaApiValidator qaApiValidator;

	@Mock
	private QaApiDAO qaApiDAO;

	@Mock
	private Config config;

	@InjectMocks
	private QaApiManager qaApiManager;

	@Before
	public void init() {
		initMocks(this);
	}

	@Test
	public void testGetAllQuestions() {

		when(qaApiDAO.getAllQuestions()).thenReturn(createAllQuestionsBackendResponse());
		when(qaApiTransformer.transformBeResponseToAllQuestions(any(AllQuestionsBackendResponse.class))).thenReturn(createAllQuestionsResponse());
		doNothing().when(qaApiValidator).validate();

		AllQuestionsResponse allQuestionsResponse = qaApiManager.getAllQuestions();

	}

	@Test
	public void testGetQuestion() {

		when(qaApiDAO.getQuestion(any())).thenReturn(createQuestionBackendResponse());
		when(qaApiTransformer.transformBeResponseToQuestion(any(QuestionBackendResponse.class))).thenReturn(createQuestionResponse());
		doNothing().when(qaApiValidator).validate();

		QuestionResponse questionResponse = qaApiManager.getQuestion(1);

	}

	private AllQuestionsBackendResponse createAllQuestionsBackendResponse() {
		AllQuestionsBackendResponse allQuestionsBackendResponse = new AllQuestionsBackendResponse();

		return allQuestionsBackendResponse;
	}

	private AllQuestionsResponse createAllQuestionsResponse() {
		AllQuestionsResponse allQuestionsResponse = new AllQuestionsResponse();

		return allQuestionsResponse;
	}

	private QuestionBackendResponse createQuestionBackendResponse() {
		QuestionBackendResponse questionBackendResponse = new QuestionBackendResponse();

		return questionBackendResponse;
	}

	private QuestionResponse createQuestionResponse() {
		QuestionResponse questionResponse = new QuestionResponse();

		return questionResponse;
	}
}
