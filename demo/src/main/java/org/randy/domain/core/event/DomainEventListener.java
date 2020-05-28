package org.randy.domain.core.event;

/**
 * Domain event listener
 * 
 * @author xiangyang
 *
 */
public interface DomainEventListener {

	void handle(DomainEvent event);

}
