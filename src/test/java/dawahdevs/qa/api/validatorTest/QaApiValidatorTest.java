package dawahdevs.qa.api.validatorTest;

import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import dawahdevs.qa.api.validator.QaApiValidator;

public class QaApiValidatorTest {

	@InjectMocks
	private QaApiValidator qaApiValidator;

	@Before
	public void init() {
		initMocks(this);
	}

	@Test
	public void testValidate() {

	}

}
