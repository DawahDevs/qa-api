package dawahdevs.qa.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties(prefix = "config")
@Getter
@Setter
public class Config {
	private String exampleUrl;
}
