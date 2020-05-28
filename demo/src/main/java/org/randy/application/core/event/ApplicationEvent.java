package org.randy.application.core.event;

import java.util.Date;

public abstract class ApplicationEvent {

	private final Date occurredOn;

	public ApplicationEvent() {
		occurredOn = new Date();
	}

	public Date occurredOn() {
		return occurredOn;
	}

}
