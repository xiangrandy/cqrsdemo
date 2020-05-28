package org.randy.adapter.cache;

/**
 * 缓存
 * 
 * @author x00418543
 * @param <T>
 * @since 2019年12月17日
 */
public class CacheObject<T> {

	private String key;
	private T value;
	private long expired;

	public CacheObject(String key, T value, long expired) {
		this.key = key;
		this.value = value;
		this.expired = expired;
	}

	public String getKey() {
		return key;
	}

	public T getValue() {
		return value;
	}

	public long getExpired() {
		return expired;
	}

}
