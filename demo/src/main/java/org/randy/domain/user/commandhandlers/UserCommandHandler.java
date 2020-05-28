package org.randy.domain.user.commandhandlers;

import org.randy.domain.core.command.DomainCommand;
import org.randy.domain.core.command.DomainCommandHandler;
import org.randy.domain.core.command.DomainCommandResult;
import org.randy.domain.user.commands.CreateUserCommand;
import org.randy.domain.user.commands.GraduateUserCommand;
import org.randy.domain.user.commands.RenameUserCommand;
import org.randy.domain.user.repository.UserRepository;
import org.randy.domain.user.root.GraduatedException;
import org.randy.domain.user.root.SameNameException;
import org.randy.domain.user.root.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户命令处理器
 * 
 * @author x00418543
 * @since 2020年1月6日
 */
public class UserCommandHandler implements DomainCommandHandler {

	@Autowired
	private UserRepository userRepository;

	@Transactional
	@Override
	public DomainCommandResult handle(DomainCommand command) throws SameNameException, GraduatedException {
		if (command instanceof CreateUserCommand) {
			handleUserCreateCommand((CreateUserCommand) command);
		} else if (command instanceof RenameUserCommand) {
			handleUserRenameCommand((RenameUserCommand) command);
		} else if (command instanceof GraduateUserCommand) {
			handleUserGraduateCommand((GraduateUserCommand) command);
		}
		return null;
	}

	/**
	 * 用户创建处理
	 * 
	 * @author x00418543
	 * @since 2020年1月6日
	 * @param command
	 */
	void handleUserCreateCommand(CreateUserCommand command) {
		// 创建领域对象
		User user = User.with(command.getId(), command.getUsername(), command.getPassword(), false)
				.contactWith(command.getEmail()).liveAt(command.getCountry(), command.getCity());
		// 持久化
		userRepository.save(user);
	}

	void handleUserRenameCommand(RenameUserCommand command) throws SameNameException, GraduatedException {
		// 查找领域对象
		User user = userRepository.findById(command.getId());
		// 执行业务操作
		user.rename(command.getUserName());
		// 持久化
		userRepository.save(user);
	}

	void handleUserGraduateCommand(GraduateUserCommand command) throws GraduatedException {
		// 查找领域对象
		User user = userRepository.findById(command.getId());
		// 执行业务操作
		user.graduate();
		// 持久化
		userRepository.save(user);
	}

}
