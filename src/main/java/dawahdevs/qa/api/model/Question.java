package dawahdevs.qa.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Question {
	private int id;
	private String text;
	private int userId;
	private String lang;
}
