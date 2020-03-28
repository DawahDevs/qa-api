package dawahdevs.qa.api.controller;

import dawahdevs.qa.api.entity.User;
import dawahdevs.qa.api.manager.UserManager;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import dawahdevs.qa.api.manager.QaApiManager;
import dawahdevs.qa.api.model.AllQuestionsResponse;
import dawahdevs.qa.api.model.QuestionResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

@Slf4j
@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping(value = "/v1/", produces = {MediaType.APPLICATION_JSON_VALUE})
public class QaApiController {

  private final QaApiManager qaApiManager;
  private final UserManager userManager;

  @GetMapping("/questions")
  public AllQuestionsResponse getAllQuestions() {
    log.info("getting all questions response");
    return qaApiManager.getAllQuestions();
  }

  @GetMapping("/questions/{questionId}")
  public QuestionResponse getQuestion(@PathVariable final int questionId) {
    log.info("getting question {} ", questionId);
    return qaApiManager.getQuestion(questionId);
  }

  @GetMapping("/user/{userId}")
  public @ResponseBody
  Optional<User> getUser(@PathVariable final int userId) {
    log.info("getting user {}", userId);
    return userManager.getUser(userId);
  }

  @GetMapping("/users")
  public @ResponseBody
  Iterable<User> getUsers() {
    log.info("getting all users");
    return userManager.getUsers();
  }

}
