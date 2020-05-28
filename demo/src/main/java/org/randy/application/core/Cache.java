package org.randy.application.core;

/**
 * 缓存接口
 * 
 * @author x00418543
 * @since 2019年12月13日
 */
public interface Cache<T> {

	T get(String cacheName, String key);

	void put(String cacheName, String key, T value, long expired);
}
