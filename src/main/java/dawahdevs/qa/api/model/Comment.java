package dawahdevs.qa.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Comment {
	private int id;
	private String text;
	private int answerId;
	private int userId;
	private String lang;
}
