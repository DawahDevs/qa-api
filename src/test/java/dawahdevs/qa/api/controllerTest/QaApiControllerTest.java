package dawahdevs.qa.api.controllerTest;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import dawahdevs.qa.api.manager.QaApiManager;
import dawahdevs.qa.api.model.AllQuestionsResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class QaApiControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private QaApiManager qaApiManager;

	@Before
	public void init() {
		initMocks(this);
	}

	@Test
	public void testGetAllStatuses() throws Exception {
		when(qaApiManager.getAllQuestions()).thenReturn(new AllQuestionsResponse());

		mockMvc.perform(get("/v1/questions")).andExpect(status().isOk()).andDo(print());

		verify(qaApiManager, times(1)).getAllQuestions();
	}

}
