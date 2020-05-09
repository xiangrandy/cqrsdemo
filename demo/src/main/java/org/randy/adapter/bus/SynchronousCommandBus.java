package org.randy.adapter.bus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.randy.domain.core.command.DomainCommand;
import org.randy.domain.core.command.DomainCommandBus;
import org.randy.domain.core.command.DomainCommandCallback;
import org.randy.domain.core.command.DomainCommandHandler;
import org.randy.domain.core.command.DomainCommandResult;
import org.randy.domain.core.command.InvalidCommandException;
import org.randy.domain.core.command.NoHandlerForDomainCommandException;

/**
 * Synchronous subclass of {@link DomainCommandBus}.
 * 
 * @author x00418543
 *
 */
public class SynchronousCommandBus extends DomainCommandBus {

	public Map<String, DomainCommandHandler> map = new ConcurrentHashMap<>();

	@Override
	public void subscribe(String commandName, DomainCommandHandler handler) {
		map.put(commandName, handler);
	}

	/**
	 * synchronous call without callback
	 * 
	 * @throws Exception
	 */
	@Override
	public void dispatch(DomainCommand command) {
		if (!command.isValid()) {
			throw new InvalidCommandException();
		}
		DomainCommandHandler handler = map.get(command.getCommandName());
		if (handler == null) {
			throw new NoHandlerForDomainCommandException();
		}
		try {
			handler.handle(command);
		} catch (Exception e) {

		}
	}

	@Override
	public void dispatch(DomainCommand command, DomainCommandCallback callback) {
		DomainCommandHandler handler = map.get(command.getCommandName());
		if (handler == null) {
			throw new NoHandlerForDomainCommandException();
		}
		try {
			DomainCommandResult result = handler.handle(command);
			callback.onSuccess(result);
		} catch (Throwable e) {
			callback.onFailure(e);
		}
	}

}
