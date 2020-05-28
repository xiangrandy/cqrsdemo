package org.randy.domain.user.commands;

import org.randy.domain.core.command.DomainCommand;

/**
 * 创建User命令
 * 
 * @author x00418543
 * @since 2020年1月6日
 */
public class CreateUserCommand extends DomainCommand {

	private final long id;

	private final String username;

	private final String password;

	private final String email;

	private final String country;

	private final String city;

	public CreateUserCommand(final long id, final String username, final String password, final String email,
			final String country, final String city) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.country = country;
		this.city = city;
	}

	public long getId() {
		return id;
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

	public String getCountry() {
		return country;
	}

	public String getCity() {
		return city;
	}

	@Override
	public boolean isValid() {
		// 命令验证
		if (id != 0 || username == null || password == null) {
			return false;
		}
		return true;
	}

}
