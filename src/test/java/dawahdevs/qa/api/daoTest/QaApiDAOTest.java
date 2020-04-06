package dawahdevs.qa.api.daoTest;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.RestTemplate;

import dawahdevs.qa.api.config.Config;
import dawahdevs.qa.api.dao.QaApiDAO;

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
	}

	@Test
	public void testGetQuestion() {
	}

}
