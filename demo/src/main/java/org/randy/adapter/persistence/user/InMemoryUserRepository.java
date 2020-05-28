package org.randy.adapter.persistence.user;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.randy.domain.user.root.User;

/**
 * In Memory
 * 
 * @author x00418543
 * @since 2019年12月2日
 */
public class InMemoryUserRepository {

	private Map<Long, User> userMap = new ConcurrentHashMap<>();

	private AtomicLong key = new AtomicLong(0);

	public User findById(long userId) {
		return userMap.get(userId);
	}

	public void add(User user) {
		userMap.put(key.incrementAndGet(), user);
	}

	public void update(User user) {
		long id = user.getId();
		userMap.put(id, user);
	}

	public void remove(long userId) {
		userMap.remove(userId);
	}

}
