package org.randy.adapter.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.randy.application.core.Cache;
import org.springframework.stereotype.Component;

/**
 * Cache适配器
 * 
 * @author x00418543
 * @since 2019年12月13日
 */
@Component
public class InMemoryCache<T> implements Cache<T> {

	private static int CAPACITY = 1024;

	// 适配者
	private final Map<String, Map<String, CacheObject<T>>> map = new ConcurrentHashMap<>(
			CAPACITY);

	@Override
	public T get(String cacheName, String key) {
		Map<String, CacheObject<T>> cache = map.get(cacheName);
		CacheObject<T> cacheObject = cache.get(key);
		if (null != cacheObject) {
			long cur = System.currentTimeMillis() / 1000;
			if (cacheObject.getExpired() <= 0
					|| cacheObject.getExpired() > cur) {
				T result = cacheObject.getValue();
				return result;
			}
		}
		return null;
	}

	@Override
	public void put(String cacheName, String key, T value, long expired) {
		expired = expired > 0
				? System.currentTimeMillis() / 1000 + expired
				: expired;
		CacheObject<T> cacheObject = new CacheObject<T>(key, value, expired);
		Map<String, CacheObject<T>> cache = map.get(cacheName);
		if (cache == null) {
			synchronized (this) {
				if (cache == null) {
					map.put(cacheName, new ConcurrentHashMap<>(CAPACITY));
				}
			}
		}
		cache.put(key, cacheObject);
	}

}
