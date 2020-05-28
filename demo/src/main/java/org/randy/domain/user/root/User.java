package org.randy.domain.user.root;

import org.randy.domain.core.models.AggregateRoot;
import org.randy.domain.user.events.UserCreatedEvent;
import org.randy.domain.user.events.UserGraduatedEvent;
import org.randy.domain.user.events.UserRenamedEvent;

/**
 * User聚合
 * 
 * @author x00418543
 * @since 2019年12月2日
 */
public class User extends AggregateRoot {

	private String username;

	private String password;

	private boolean graduated;

	private String email;

	private Address address;

	private User(long id, String username, String password, boolean graduated) {
		super(id);
		this.username = username;
		this.password = password;
		this.graduated = graduated;
	}

	public static User with(long id, String username, String password,
			boolean graduated) {
		User user = new User(id, username, password, graduated);
		UserCreatedEvent event = new UserCreatedEvent(id, username);
		user.events.add(event);
		return user;
	}

	public User liveAt(String country, String city) {
		Address address = new Address(country, city);
		this.address = address;
		return this;
	}

	public User contactWith(String emailAddress) {
		this.email = emailAddress;
		return this;
	}

	public void rename(final String name)
			throws SameNameException, GraduatedException {
		if (this.graduated) {
			throw new GraduatedException();
		}
		if (this.username.equals(name)) {
			throw new SameNameException();
		}
		this.username = name;
		UserRenamedEvent event = new UserRenamedEvent(this.id, this.username);
		events.add(event);
	}

	public void graduate() throws GraduatedException {
		if (this.graduated) {
			throw new GraduatedException();
		}
		this.graduated = true;
		UserGraduatedEvent event = new UserGraduatedEvent(this.id);
		events.add(event);
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public boolean isGraduated() {
		return graduated;
	}

	public Address getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", email=" + email + ", graduated=" + graduated + ", address="
				+ address + ", id=" + id + "]";
	}

}