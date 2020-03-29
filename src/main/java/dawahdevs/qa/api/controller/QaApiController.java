package dawahdevs.qa.api.controller;

import dawahdevs.qa.api.entity.Author;
import dawahdevs.qa.api.entity.Question;
import dawahdevs.qa.api.entity.User;
import dawahdevs.qa.api.manager.AuthorManager;
import dawahdevs.qa.api.manager.UserManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import dawahdevs.qa.api.manager.QuestionManager;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/v1/", produces = {MediaType.APPLICATION_JSON_VALUE})
public class QaApiController {

  private final QuestionManager qaApiManager;
  private final UserManager userManager;
  private final AuthorManager authorManager;

  @GetMapping("/questions")
  public @ResponseBody
  Iterable<Question> getQuestions() {
    log.info("getting all questions response");
    return qaApiManager.getQuestions();
  }

  @GetMapping("/question/{questionId}")
  public @ResponseBody
  Optional<Question> getQuestion(@PathVariable final int questionId) {
    log.info("getting question {} ", questionId);
    return qaApiManager.getQuestion(questionId);
  }

  @GetMapping("/users")
  public @ResponseBody
  Iterable<User> getUsers() {
    log.info("getting all users");
    return userManager.getUsers();
  }

  @GetMapping("/user/{userId}")
  public @ResponseBody
  Optional<User> getUser(@PathVariable final int userId) {
    log.info("getting user {}", userId);
    return userManager.getUser(userId);
  }

  @GetMapping("/author/{authorId}")
  public @ResponseBody
  Optional<Author> getAuthor(@PathVariable final int authorId) {
    log.info("getting author {}", authorId);
    return authorManager.getAuthor(authorId);
  }
}
