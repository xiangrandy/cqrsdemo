package org.randy.domain.core;

import java.io.Serializable;

/**
 * 唯一标识
 * 
 * @author x00418543
 * @since 2019年12月19日
 */
public interface Identity<T> extends Serializable {

	T value();

	boolean isEmpty();

	T emptyId();

}
