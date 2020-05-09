package org.randy.domain.core.repository;

import org.randy.domain.core.models.AggregateRoot;

/**
 * 资源库抽象类
 * 
 * @author x00418543
 * @since 2019年12月12日
 */
public interface AggregateRootRepository<R extends AggregateRoot> {

	R findById(long id);

	void save(R root);

	void remove(R root);

}