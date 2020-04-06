package dawahdevs.qa.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Answer {
	private int id;
	private String text;
	private int questionId;
	private int authorId;
	private String lang;
}
