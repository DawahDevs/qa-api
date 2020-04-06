package dawahdevs.qa.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Author {
	private int id;
	private String name;
	private String seniority;
	private String school;
	private String defaultLang;
}
