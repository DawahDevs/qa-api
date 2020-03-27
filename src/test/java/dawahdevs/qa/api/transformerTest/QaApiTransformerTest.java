package dawahdevs.qa.api.transformerTest;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import dawahdevs.qa.api.model.AllQuestionsBackendResponse;
import dawahdevs.qa.api.model.AllQuestionsResponse;
import dawahdevs.qa.api.model.QuestionBackendResponse;
import dawahdevs.qa.api.model.QuestionResponse;
import dawahdevs.qa.api.transformer.QaApiTransformer;

public class QaApiTransformerTest {

	@InjectMocks
	private QaApiTransformer qaApiTransformer;

	@Before
	public void init() {
		initMocks(this);
	}

	@Test
	public void testTransformBeResponseToAllQuestions() {

		AllQuestionsResponse allQuestionsResponse = qaApiTransformer.transformBeResponseToAllQuestions(createAllQuestionsBackendResponse());

	}

	@Test
	public void testTransformBeResponseToQuestion() {

		QuestionResponse sampleResponse = qaApiTransformer.transformBeResponseToQuestion(createQuestionBackendResponse());

	}

	private AllQuestionsBackendResponse createAllQuestionsBackendResponse() {
		AllQuestionsBackendResponse allQuestionsBackendResponse = new AllQuestionsBackendResponse();

		return allQuestionsBackendResponse;
	}

	private QuestionBackendResponse createQuestionBackendResponse() {
		QuestionBackendResponse questionBackendResponse = new QuestionBackendResponse();

		return questionBackendResponse;
	}

}
