package org.randy.domain.department.event;

import org.randy.domain.core.event.DomainEvent;

public class EmployeeRemovedEvent extends DomainEvent {

	private final long departmentId;

	private final long userId;

	public EmployeeRemovedEvent(long departmentId, long userId) {
		super();
		this.departmentId = departmentId;
		this.userId = userId;
	}

	public long getDepartmentId() {
		return departmentId;
	}

	public long getUserId() {
		return userId;
	}

}
