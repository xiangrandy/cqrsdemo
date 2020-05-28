package org.randy.domain.core.command;

import java.util.Date;

/**
 * The abstract class of domain command.
 * 
 * @author xiangyang
 *
 */
public abstract class DomainCommand {

	private final Date releasedAt;

	public DomainCommand() {
		releasedAt = new Date();
	}

	public Date releasedAt() {
		return releasedAt;
	}

	public String getCommandName() {
		return this.getClass().getName();
	}

	public abstract boolean isValid();

}
