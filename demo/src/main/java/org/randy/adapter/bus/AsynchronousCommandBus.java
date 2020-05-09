package org.randy.adapter.bus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.randy.domain.core.command.DomainCommand;
import org.randy.domain.core.command.DomainCommandBus;
import org.randy.domain.core.command.DomainCommandCallback;
import org.randy.domain.core.command.DomainCommandHandler;
import org.randy.domain.core.command.DomainCommandResult;
import org.randy.domain.core.command.NoHandlerForDomainCommandException;

/**
 * Asynchronous subclass of {@link DomainCommandBus}.
 * 
 * @author x00418543
 *
 */
public class AsynchronousCommandBus extends DomainCommandBus {

	public Map<String, DomainCommandHandler> map = new ConcurrentHashMap<>();

	private final Executor executor;

	public AsynchronousCommandBus() {
		this(Executors.newCachedThreadPool());
	}

	public AsynchronousCommandBus(Executor executor) {
		this.executor = executor;
	}

	@Override
	public void subscribe(String commandName, DomainCommandHandler handler) {
		map.put(commandName, handler);
	}

	@Override
	public void dispatch(DomainCommand command) {
		DomainCommandHandler handler = map.get(command.getCommandName());
		if (handler == null) {
			throw new NoHandlerForDomainCommandException();
		}
		Runnable r = new Runnable() {

			@Override
			public void run() {
				try {
					handler.handle(command);
				} catch (Exception e) {
				}
			}

		};
		executor.execute(r);
	}

	@Override
	public void dispatch(DomainCommand command, DomainCommandCallback callback) {
		DomainCommandHandler handler = map.get(command.getCommandName());
		if (handler == null) {
			throw new NoHandlerForDomainCommandException();
		}
		Runnable r = new Runnable() {

			@Override
			public void run() {
				try {
					DomainCommandResult result = handler.handle(command);
					callback.onSuccess(result);
				} catch (Throwable e) {
					callback.onFailure(e);
				}
			}

		};
		executor.execute(r);
	}

}
