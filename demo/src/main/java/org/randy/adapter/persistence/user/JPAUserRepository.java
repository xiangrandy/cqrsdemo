package org.randy.adapter.persistence.user;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.randy.adapter.persistence.Mapper;
import org.randy.domain.core.event.DomainEvent;
import org.randy.domain.core.event.DomainEventBus;
import org.randy.domain.user.repository.UserRepository;
import org.randy.domain.user.root.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * 用户资源库适配器
 * 
 * @author x00418543
 * @since 2019年12月2日
 */
@Repository
public class JPAUserRepository implements UserRepository {

	@Autowired
	@PersistenceContext
	private EntityManager em;

	@Autowired
	private DomainEventBus eventBus;

	private Mapper<UserPO, User> mapper = new UserMapper();

	@Override
	public User findById(long id) {
		UserPO userPO = em.find(UserPO.class, id);
		User user = mapper.toAggregateRoot(userPO);
		return user;
	}

	@Override
	public void save(User user) {
		if (user.getId() == 0) {
			insert(user);
		} else {
			update(user);
		}
		List<DomainEvent> events = user.getEvents();
		events.forEach(event -> eventBus.raise(event));
		user.clearEvents();
	}

	private void insert(User user) {
		UserPO userPO = mapper.toPersistantObject(user);
		em.persist(userPO);
	}

	private void update(User user) {
		UserPO userPO = mapper.toPersistantObject(user);
		em.merge(userPO);
	}

	@Override
	public void remove(User user) {
		UserPO userPO = new UserPO();
		userPO.setId(user.getId());
		em.remove(userPO);
	}

}
