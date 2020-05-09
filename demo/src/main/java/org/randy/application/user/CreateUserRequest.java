package org.randy.application.user;

/**
 * 创建User请求
 * 
 * @author x00418543
 * @since 2019年12月2日
 */
public class CreateUserRequest {

	private String username;

	private String password;

	private String email;

	private String country;

	private String city;

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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
