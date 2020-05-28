package org.randy.domain.core.event;

import java.util.List;

/**
 * 事件总线，发布订阅模式，一个event被多个listener订阅
 * 
 * @author xiangyang
 */
public abstract class DomainEventBus {

	public abstract <E extends DomainEvent> void subscribe(Class<E> commandClazz, DomainEventListener listener);

	public abstract <E extends DomainEvent> void raise(E event);

	public abstract <E extends DomainEvent> void raise(List<E> events);

}
