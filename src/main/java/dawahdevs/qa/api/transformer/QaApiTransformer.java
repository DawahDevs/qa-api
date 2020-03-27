package dawahdevs.qa.api.transformer;

import org.springframework.stereotype.Component;

import dawahdevs.qa.api.model.AllQuestionsBackendResponse;
import dawahdevs.qa.api.model.AllQuestionsResponse;
import dawahdevs.qa.api.model.QuestionBackendResponse;
import dawahdevs.qa.api.model.QuestionResponse;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class QaApiTransformer {

	public AllQuestionsResponse transformBeResponseToAllQuestions(final AllQuestionsBackendResponse allQuestionsBackendResponse) {
		AllQuestionsResponse allQuestionsResponse = new AllQuestionsResponse();

		return allQuestionsResponse;
	}

	public QuestionResponse transformBeResponseToQuestion(final QuestionBackendResponse questionBackendResponse) {
		QuestionResponse questionResponse = new QuestionResponse();

		return questionResponse;
	}

}