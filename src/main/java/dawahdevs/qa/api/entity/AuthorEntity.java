package dawahdevs.qa.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "author")
public class AuthorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Length(max = 100)
	private String name;

	private Seniority seniority;

	private School school;

	private Lang defaultLang;
}
