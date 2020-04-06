package dawahdevs.qa.api.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import dawahdevs.qa.api.config.Config;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@AllArgsConstructor
public class QaApiDAO {

	private final RestTemplate restTemplate;
	private final Config config;

}
