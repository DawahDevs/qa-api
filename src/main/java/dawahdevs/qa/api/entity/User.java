package dawahdevs.qa.api.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;

  @Length(max = 45)
  private String name;

  private Lang defaultLang;
}
