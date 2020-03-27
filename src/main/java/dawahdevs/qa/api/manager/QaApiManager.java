package dawahdevs.qa.api.manager;

import org.springframework.stereotype.Service;

import dawahdevs.qa.api.dao.QaApiDAO;
import dawahdevs.qa.api.model.AllQuestionsBackendResponse;
import dawahdevs.qa.api.model.AllQuestionsResponse;
import dawahdevs.qa.api.model.QuestionBackendResponse;
import dawahdevs.qa.api.model.QuestionResponse;
import dawahdevs.qa.api.transformer.QaApiTransformer;
import dawahdevs.qa.api.validator.QaApiValidator;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QaApiManager {

	private final QaApiDAO qaApiDAO;
	private final QaApiTransformer qaApiTransformer;
	private final QaApiValidator qaApiValidator;

	public AllQuestionsResponse getAllQuestions() {
		qaApiValidator.validate();

		AllQuestionsBackendResponse allQuestionsBackendResponse = qaApiDAO.getAllQuestions();

		return qaApiTransformer.transformBeResponseToAllQuestions(allQuestionsBackendResponse);
	}
	
	public QuestionResponse getQuestion(final int questionId) {
		qaApiValidator.validate();
	
		QuestionBackendResponse questionBackendResponse = qaApiDAO.getQuestion(questionId);
	
		return qaApiTransformer.transformBeResponseToQuestion(questionBackendResponse);
	}

}