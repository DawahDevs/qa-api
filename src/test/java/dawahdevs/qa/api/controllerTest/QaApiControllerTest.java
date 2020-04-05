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
import dawahdevs.qa.api.model.AllAuthorsResponse;
import dawahdevs.qa.api.model.AllQuestionsResponse;
import dawahdevs.qa.api.model.AllUsersResponse;
import dawahdevs.qa.api.model.AuthorByIdResponse;
import dawahdevs.qa.api.model.QuestionByIdResponse;
import dawahdevs.qa.api.model.UserByIdResponse;

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
	public void testGetQuestions() throws Exception {
		when(qaApiManager.getQuestions()).thenReturn(new AllQuestionsResponse());

		mockMvc.perform(get("/v1/questions")).andExpect(status().isOk()).andDo(print());

		verify(qaApiManager, times(1)).getQuestions();
	}

	@Test
	public void testGetQuestionById() throws Exception {
		when(qaApiManager.getQuestionById(1)).thenReturn(new QuestionByIdResponse());

		mockMvc.perform(get("/v1/questions/1")).andExpect(status().isOk()).andDo(print());

		verify(qaApiManager, times(1)).getQuestionById(1);
	}

	@Test
	public void testGetUsers() throws Exception {
		when(qaApiManager.getUsers()).thenReturn(new AllUsersResponse());

		mockMvc.perform(get("/v1/users")).andExpect(status().isOk()).andDo(print());

		verify(qaApiManager, times(1)).getUsers();
	}

	@Test
	public void testGetUserById() throws Exception {
		when(qaApiManager.getUserById(1)).thenReturn(new UserByIdResponse());

		mockMvc.perform(get("/v1/users/1")).andExpect(status().isOk()).andDo(print());

		verify(qaApiManager, times(1)).getUserById(1);
	}

	@Test
	public void testGetAuthors() throws Exception {
		when(qaApiManager.getAuthors()).thenReturn(new AllAuthorsResponse());

		mockMvc.perform(get("/v1/authors")).andExpect(status().isOk()).andDo(print());

		verify(qaApiManager, times(1)).getAuthors();
	}

	@Test
	public void testGetAuthorById() throws Exception {
		when(qaApiManager.getAuthorById(1)).thenReturn(new AuthorByIdResponse());

		mockMvc.perform(get("/v1/authors/1")).andExpect(status().isOk()).andDo(print());

		verify(qaApiManager, times(1)).getAuthorById(1);
	}

}
