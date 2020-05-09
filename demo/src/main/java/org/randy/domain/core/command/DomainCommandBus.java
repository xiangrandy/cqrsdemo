package org.randy.domain.core.command;

/**
 * abstract DomainCommandBus,dispatches DomainCommand to DomainCommandHandler.
 * 
 * @author x00418543
 */
public abstract class DomainCommandBus {

	/**
	 * 
	 * @param command The command to dispatch.
	 * @throws Exception
	 * @throws NoHandlerForDomainCommandException when no command handler is
	 *                                            registered for the given
	 *                                            <code>command</code>.
	 */
	public abstract void dispatch(DomainCommand command);

	/**
	 * 
	 * @param command  The command to dispatch.
	 * @param callback The callback to invoke when command processing is complete.
	 * @throws NoHandlerForDomainCommandException when no command handler is
	 *                                            registered for the given
	 *                                            <code>command</code>.
	 */
	public abstract void dispatch(DomainCommand command, DomainCommandCallback callback);

	/**
	 * 
	 * @param commandName
	 * @param handler
	 */
	public abstract void subscribe(String commandName, DomainCommandHandler handler);

}
