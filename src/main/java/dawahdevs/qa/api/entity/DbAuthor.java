package dawahdevs.qa.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class DbAuthor {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;

  @Length(max = 100)
  private String name;

  private Seniority seniority;

  private School school;

  private Lang defaultLang;
}
