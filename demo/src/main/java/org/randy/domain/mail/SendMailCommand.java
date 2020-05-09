package org.randy.domain.mail;

import org.randy.domain.core.command.DomainCommand;

public class SendMailCommand extends DomainCommand {

	private final String message;

	@Override
	public boolean isValid() {
		return true;
	}

	public SendMailCommand(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
