package dawahdevs.qa.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "answer")
public class AnswerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Length(max = 100)
	private String text;

	@OneToOne
	@JoinColumn
	private QuestionEntity question;

	@OneToOne
	@JoinColumn
	private AuthorEntity author;

	private Lang lang;
}
