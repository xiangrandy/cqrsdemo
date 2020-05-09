package org.randy.adapter.persistence;

import org.randy.domain.core.models.AggregateRoot;

/**
 * 映射器
 * 
 * @author x00418543
 * @since 2019年12月13日
 */
public interface Mapper<P extends Persistantable<R>, R extends AggregateRoot> {

	R toAggregateRoot(P p);

	P toPersistantObject(R r);
}
