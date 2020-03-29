package dawahdevs.qa.api.manager;

import dawahdevs.qa.api.entity.Author;
import dawahdevs.qa.api.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthorManager {
  private AuthorRepository authorRepository;

  public Optional<Author> getAuthor(int authorId) {
    return authorRepository.findById(authorId);
  }

}
