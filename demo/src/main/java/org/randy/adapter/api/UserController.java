package org.randy.adapter.api;

import org.randy.application.core.ApplicationException;
import org.randy.application.user.CreateUserRequest;
import org.randy.application.user.UserApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserApplicationService userApplicationService;

	@PostMapping()
	public void addUser(@RequestBody CreateUserRequest request) {
		userApplicationService.addUser(request);
	}

	@DeleteMapping("/{id}")
	public void graduate(@PathVariable("id") long userId)
			throws ApplicationException {
		userApplicationService.graduate(userId);
	}

	@PutMapping("/{id}/{name}")
	public void rename(@PathVariable("id") long userId,
			@PathVariable("name") String name) throws ApplicationException {
		userApplicationService.updateUserName(userId, name);
	}

}