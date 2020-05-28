package org.randy.application.user;

import org.randy.domain.user.root.User;

/**
 * UserDTO
 * 
 * @author x00418543
 * @since 2019年12月2日
 */
public class UserDTO {

	private long id;

	private String username;

	private String password;

	private String email;

	private boolean graduated;

	public UserDTO(User user) {
		this.id = user.getId();
		this.username = user.getUsername();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.graduated = user.isGraduated();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isGraduated() {
		return graduated;
	}

	public void setGraduated(boolean graduated) {
		this.graduated = graduated;
	}

}
