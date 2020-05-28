package org.randy.domain.user.commands;

import org.randy.domain.core.command.DomainCommand;

/**
 * 毕业命令
 * 
 * @author x00418543
 * @since 2020年4月18日
 */
public class GraduateUserCommand extends DomainCommand {

	private final long id;

	public GraduateUserCommand(long userId) {
		this.id = userId;
	}

	public long getId() {
		return id;
	}

	@Override
	public boolean isValid() {
		return true;
	}

}
