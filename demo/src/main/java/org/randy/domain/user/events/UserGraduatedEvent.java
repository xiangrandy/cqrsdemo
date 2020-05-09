package org.randy.domain.user.events;

import org.randy.domain.core.event.DomainEvent;

/**
 * 用户毕业事件
 * 
 * @author x00418543
 * @since 2019年12月4日
 */
public class UserGraduatedEvent extends DomainEvent {

	private final long userId;

	public UserGraduatedEvent(long userId) {
		super();
		this.userId = userId;
	}

	public long getUserId() {
		return userId;
	}

}
