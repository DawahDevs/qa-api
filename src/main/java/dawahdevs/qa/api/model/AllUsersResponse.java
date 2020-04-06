package dawahdevs.qa.api.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AllUsersResponse {
	private List<User> users;
}
