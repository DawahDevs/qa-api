package dawahdevs.qa.api.dao;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import dawahdevs.qa.api.config.Config;
import dawahdevs.qa.api.model.AllQuestionsBackendResponse;
import dawahdevs.qa.api.model.QuestionBackendResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@AllArgsConstructor
public class QaApiDAO {

	private final RestTemplate restTemplate;
	private final Config config;

	@HystrixCommand
	public AllQuestionsBackendResponse getAllQuestions() {
		try {
			return restTemplate.exchange(config.getExampleUrl(), HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), AllQuestionsBackendResponse.class).getBody();
		} catch (RestClientResponseException e) {
			log.error(e.getMessage());
			throw new RuntimeException(e.getResponseBodyAsString());
		}
	}

	@HystrixCommand
	public QuestionBackendResponse getQuestion(final int questionId) {
		try {
			return restTemplate.exchange(config.getExampleUrl(), HttpMethod.GET, new HttpEntity<>(new HttpHeaders()), QuestionBackendResponse.class, questionId).getBody();
		} catch (RestClientResponseException e) {
			log.error(e.getMessage());
			throw new RuntimeException(e.getResponseBodyAsString());
		}
	}

}
