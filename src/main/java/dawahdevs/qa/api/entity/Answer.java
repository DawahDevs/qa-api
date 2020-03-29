package dawahdevs.qa.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Answer {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;

  @Length(max = 100)
  private String text;

  @OneToOne
  @JoinColumn
  private Question questionId;

  @OneToOne
  @JoinColumn
  private Author answeredBy;
}
