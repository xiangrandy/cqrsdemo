package org.randy.adapter.persistence.user;

import org.randy.adapter.persistence.Mapper;
import org.randy.domain.user.root.User;

/**
 * UserMapper
 * 
 * @author x00418543
 * @since 2019年12月13日
 */
public class UserMapper implements Mapper<UserPO, User> {

	@Override
	public User toAggregateRoot(UserPO p) {
		return User.with(p.getId(), p.getUsername(), p.getPassword(), p.isGraduated()).contactWith(p.getEmail())
				.liveAt(p.getCountry(), p.getCity());
	}

	@Override
	public UserPO toPersistantObject(User user) {
		UserPO po = new UserPO();
		po.setId(user.getId());
		po.setUsername(user.getUsername());
		po.setPassword(user.getPassword());
		po.setGraduated(user.isGraduated());
		po.setEmail(user.getEmail());
		po.setCountry(user.getAddress().getCountry());
		po.setCity(user.getAddress().getCity());
		return po;
	}

}
