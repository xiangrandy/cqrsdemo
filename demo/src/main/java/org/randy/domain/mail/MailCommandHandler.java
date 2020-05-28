package org.randy.domain.mail;

import org.randy.domain.core.command.DomainCommand;
import org.randy.domain.core.command.DomainCommandHandler;
import org.randy.domain.core.command.DomainCommandResult;

public class MailCommandHandler implements DomainCommandHandler {

	@Override
	public DomainCommandResult handle(DomainCommand command) {
		if (command instanceof SendMailCommand) {
			handleSendMailCommand((SendMailCommand) command);
		}
		return null;
	}

	void handleSendMailCommand(SendMailCommand command) {
		System.out.println("发送邮件成功，内容为：" + command.getMessage());
	}

}
