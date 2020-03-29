package dawahdevs.qa.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Question {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;

  @Length(max = 100)
  private String text;

  @ManyToOne
  @JoinColumn
  private User askedBy;
}
