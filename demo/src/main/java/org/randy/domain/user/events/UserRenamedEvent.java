package org.randy.domain.user.events;

import org.randy.domain.core.event.DomainEvent;

/**
 * 用户改名事件
 * 
 * @author x00418543
 * @since 2019年12月3日
 */
public class UserRenamedEvent extends DomainEvent {

	private final long userId;

	private final String nameAfter;

	public UserRenamedEvent(long userId, String nameAfter) {
		super();
		this.userId = userId;
		this.nameAfter = nameAfter;
	}

	public long getUserId() {
		return userId;
	}

	public String getNameAfter() {
		return nameAfter;
	}

}
