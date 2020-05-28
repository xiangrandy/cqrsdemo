package org.randy.adapter.bus;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.randy.domain.core.event.DomainEvent;
import org.randy.domain.core.event.DomainEventBus;
import org.randy.domain.core.event.DomainEventListener;
import org.randy.domain.core.event.NoListenerForDomainEventException;

/**
 * Synchronous subclass of {@link DomainEventBus}.
 * 
 * @author x00418543
 *
 */
public class SynchronousEventBus extends DomainEventBus {

	public Map<Class<? extends DomainEvent>, List<DomainEventListener>> map = new ConcurrentHashMap<>();

	@Override
	public synchronized <E extends DomainEvent> void subscribe(Class<E> eventClazz, DomainEventListener eventListener) {
		List<DomainEventListener> listeners = map.get(eventClazz);
		if (listeners == null) {
			listeners = new ArrayList<>();
			map.put(eventClazz, listeners);
		}
		listeners.add(eventListener);
	}

	@Override
	public <E extends DomainEvent> void raise(E event) {
		List<DomainEventListener> listeners = map.get(event.getClass());
		if (listeners == null || listeners.isEmpty()) {
			throw new NoListenerForDomainEventException();
		}
		for (DomainEventListener listener : listeners) {
			try {
				listener.handle(event);
			} catch (Exception e) {

			}
		}
	}

	@Override
	public <E extends DomainEvent> void raise(List<E> events) {
		// TODO unimplemented
	}

}
