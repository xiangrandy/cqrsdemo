package org.randy.domain.core;

import java.io.Serializable;

/**
 * Identity
 * 
 * @author x00418543
 * @since 2019年12月19日
 */
public interface Identity<T> extends Serializable {

	T value();

	boolean isEmpty();

	T emptyId();

}
