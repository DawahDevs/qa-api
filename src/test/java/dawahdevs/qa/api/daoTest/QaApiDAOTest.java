package dawahdevs.qa.api.daoTest;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import dawahdevs.qa.api.config.Config;
import dawahdevs.qa.api.dao.QaApiDAO;
import dawahdevs.qa.api.model.AllQuestionsBackendResponse;
import dawahdevs.qa.api.model.QuestionBackendResponse;

public class QaApiDAOTest {

	@Spy
	private Config config;

	@Spy
	private RestTemplate restTemplate;

	private MockRestServiceServer mockRestServiceServer;

	@InjectMocks
	private QaApiDAO qaApiDAO;

	private static final String BACKEND_RESPONSE = "{ \"sampleInt\": 1, \"sampleString\": \"Example\" }";

	@Before
	public void init() {
		initMocks(this);
		config.setExampleUrl("https://api.qvc.com/us");
		mockRestServiceServer = MockRestServiceServer.createServer(restTemplate);
	}

	@Test
	public void testGetAllQuestions() {

		mockRestServiceServer.expect(requestTo("https://api.qvc.com/us")).andExpect(method(HttpMethod.GET))
				.andRespond(withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(BACKEND_RESPONSE));

		AllQuestionsBackendResponse allQuestionsBackendResponse = qaApiDAO.getAllQuestions();

	}

	@Test
	public void testGetQuestion() {

		mockRestServiceServer.expect(requestTo("https://api.qvc.com/us")).andExpect(method(HttpMethod.GET))
				.andRespond(withStatus(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(BACKEND_RESPONSE));

		QuestionBackendResponse questionBackendResponse = qaApiDAO.getQuestion(1);

	}

}
