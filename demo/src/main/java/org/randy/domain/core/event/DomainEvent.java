package org.randy.domain.core.event;

import java.util.Date;

/**
 * 
 * @author xiangyang
 *
 */
public abstract class DomainEvent {

	private final Date occurredOn;

	public DomainEvent() {
		occurredOn = new Date();
	}

	public Date occurredOn() {
		return occurredOn;
	}

}
