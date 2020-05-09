package org.randy.domain.core.event;

public interface DomainEventListener {

	void handle(DomainEvent event);

}
