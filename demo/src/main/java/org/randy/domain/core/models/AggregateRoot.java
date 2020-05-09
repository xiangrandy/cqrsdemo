package org.randy.domain.core.models;

import java.util.LinkedList;
import java.util.List;

import org.randy.domain.core.event.DomainEvent;

/**
 * 聚合根基类
 * 
 * @author x00418543
 * @since 2019年12月13日
 */
public abstract class AggregateRoot {

	protected long id;

	protected transient List<DomainEvent> events = new LinkedList<>();

	public AggregateRoot() {

	}

	public AggregateRoot(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public List<DomainEvent> getEvents() {
		return events;
	}

	public void clearEvents() {
		events.clear();
	}

}
