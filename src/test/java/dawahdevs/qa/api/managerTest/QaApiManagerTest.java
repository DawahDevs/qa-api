package dawahdevs.qa.api.managerTest;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import dawahdevs.qa.api.manager.QaApiManager;

public class QaApiManagerTest {

//	@Mock
//	private final QaApiTransformer qaApiTransformer;
//
//	@Mock
//	private final QuestionRepository questionRepository;
//
//	@Mock
//	private final UserRepository userRepository;
//
//	@Mock
//	private final AuthorRepository authorRepository;

	@InjectMocks
	private QaApiManager qaApiManager;

	@Before
	public void init() {
		initMocks(this);

	}

	@Test
	public void testGetQuestions() {
	}

}
