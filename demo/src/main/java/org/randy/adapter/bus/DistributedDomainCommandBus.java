package org.randy.adapter.bus;

import org.randy.domain.core.command.DomainCommand;
import org.randy.domain.core.command.DomainCommandBus;
import org.randy.domain.core.command.DomainCommandCallback;
import org.randy.domain.core.command.DomainCommandHandler;

/**
 * Distributed Domain Command Bus.
 * 
 * @author x00418543
 *
 */
public class DistributedDomainCommandBus extends DomainCommandBus {

	@Override
	public void dispatch(DomainCommand command) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispatch(DomainCommand command, DomainCommandCallback callback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void subscribe(String commandName, DomainCommandHandler handler) {
		// TODO Auto-generated method stub

	}

}
