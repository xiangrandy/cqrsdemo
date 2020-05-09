package org.randy.adapter.bus;

import java.util.List;

import org.randy.domain.core.event.DomainEvent;
import org.randy.domain.core.event.DomainEventBus;
import org.randy.domain.core.event.DomainEventListener;

/**
 * Distributed Domain Event Bus.
 * 
 * @author x00418543
 *
 */
public class DistributedDomainEventBus extends DomainEventBus {

	@Override
	public <E extends DomainEvent> void subscribe(Class<E> commandClazz, DomainEventListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public <E extends DomainEvent> void raise(E event) {
		// TODO Auto-generated method stub

	}

	@Override
	public <E extends DomainEvent> void raise(List<E> events) {
		// TODO Auto-generated method stub

	}

}
