package dawahdevs.qa.api.manager;

import dawahdevs.qa.api.entity.Author;
import dawahdevs.qa.api.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorManager {
  private AuthorRepository authorRepository;

  public @ResponseBody
  Optional<Author> getAuthor(@PathVariable final int authorId) {
    return authorRepository.findById(authorId);
  }

}
