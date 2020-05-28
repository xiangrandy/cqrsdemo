package org.randy.domain.core.repository;

import org.randy.domain.core.models.AggregateRoot;

/**
 * repository
 * 
 * @author xiangyang
 */
public interface AggregateRootRepository<R extends AggregateRoot> {

	R findById(long id);

	void save(R root);

	void remove(R root);

}