package dawahdevs.qa.api.managerTest;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import dawahdevs.qa.api.manager.QuestionManager;

public class QaApiManagerTest {

	@InjectMocks
	private QuestionManager qaApiManager;

	@Before
	public void init() {
		initMocks(this);
	}

	@Test
	public void testGetQuestions() {
	}

	@Test
	public void testGetQuestion() {
	}

}
