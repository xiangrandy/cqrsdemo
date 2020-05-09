package org.randy.domain.core.command;

/**
 * Marks an instance that is capable of handling domain commands. Domain command
 * handlers need to be subscribed to a {@link DomainCommandBus} in order to
 * receive {@link DomainCommand}.
 * 
 * @author x00418543
 *
 */
public interface DomainCommandHandler {

	/**
	 * Handles {@link DomainCommand}.
	 * 
	 * @param command The DomainCommand that sends from DomainCommandBus.
	 * @throws Exception
	 */
	DomainCommandResult handle(DomainCommand command) throws Exception;

}
