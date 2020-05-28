package org.randy.domain.user.events;

import org.randy.domain.core.event.DomainEvent;

/**
 * 用户创建事件
 * 
 * @author x00418543
 * @since 2019年12月18日
 */
public class UserCreatedEvent extends DomainEvent {

	private final long id;

	public UserCreatedEvent(long id, String usesrName) {
		super();
		this.id = id;
	}

	public long getId() {
		return id;
	}

}
