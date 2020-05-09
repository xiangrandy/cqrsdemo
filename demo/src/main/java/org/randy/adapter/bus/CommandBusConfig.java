package org.randy.adapter.bus;

import org.randy.domain.core.command.DomainCommandBus;
import org.randy.domain.mail.MailCommandHandler;
import org.randy.domain.user.commandhandlers.UserCommandHandler;
import org.randy.domain.user.commands.CreateUserCommand;
import org.randy.domain.user.commands.GraduateUserCommand;
import org.randy.domain.user.commands.RenameUserCommand;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CommandBusConfig {

	@Bean
	public DomainCommandBus synchronousCommandBus() {
		SynchronousCommandBus bus = new SynchronousCommandBus();
		bus.subscribe(CreateUserCommand.class.getName(), userCommandHandler());
		bus.subscribe(RenameUserCommand.class.getName(), userCommandHandler());
		bus.subscribe(GraduateUserCommand.class.getName(), userCommandHandler());
		return bus;
	}

	@Bean
	public UserCommandHandler userCommandHandler() {
		return new UserCommandHandler();
	}

	@Bean
	public MailCommandHandler mailCommandHandler() {
		return new MailCommandHandler();
	}

}
