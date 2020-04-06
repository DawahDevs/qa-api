package dawahdevs.qa.api.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionByIdResponse {
	private Question question;
	private List<Answer> answers;
	private List<Comment> comments;
}
