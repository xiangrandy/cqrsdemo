package org.randy.application.user;

import org.randy.application.core.ApplicationException;
import org.randy.domain.core.command.DomainCommandBus;
import org.randy.domain.mail.SendMailCommand;
import org.randy.domain.user.commands.CreateUserCommand;
import org.randy.domain.user.commands.GraduateUserCommand;
import org.randy.domain.user.commands.RenameUserCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserApplicationService {

	@Autowired
	private DomainCommandBus bus;

	public void addUser(CreateUserRequest request) {
		long id = 0;
		CreateUserCommand createUserCommand = new CreateUserCommand(id,
				request.getUsername(), request.getPassword(),
				request.getEmail(), request.getCountry(), request.getCity());
		if (!createUserCommand.isValid()) {
			return;
		}
		bus.dispatch(createUserCommand);
		SendMailCommand sendMailCommand = new SendMailCommand(
				"用户" + request.getUsername() + "创建成功。");
		bus.dispatch(sendMailCommand);
	}

	public void updateUserName(long userId, String userName)
			throws ApplicationException {
		RenameUserCommand command = new RenameUserCommand(userId, userName);
		bus.dispatch(command);
	}

	public void graduate(long userId) throws ApplicationException {
		GraduateUserCommand command = new GraduateUserCommand(userId);
		bus.dispatch(command);
	}

}
