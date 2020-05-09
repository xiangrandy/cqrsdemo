package org.randy.domain.user.commands;

import org.randy.domain.core.command.DomainCommand;

/**
 * 改名命令
 * 
 * @author x00418543
 * @since 2020年1月6日
 */
public class RenameUserCommand extends DomainCommand {

	private final long id;

	private final String userName;

	public RenameUserCommand(long id, String userName) {
		this.id = id;
		this.userName = userName;
	}

	public long getId() {
		return id;
	}

	public String getUserName() {
		return userName;
	}

	@Override
	public boolean isValid() {
		return true;
	}

}
