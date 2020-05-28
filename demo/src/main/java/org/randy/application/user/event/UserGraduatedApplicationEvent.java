package org.randy.application.user.event;

/**
 * TODO 在此添加类型注释
 * 
 * @author x00418543
 * @since 2019年12月12日
 */
public class UserGraduatedApplicationEvent {

	private final long id;

	private final String userName;

	public UserGraduatedApplicationEvent(final long id, final String userName) {
		this.id = id;
		this.userName = userName;
	}

	public long getId() {
		return id;
	}

	public String getUserName() {
		return this.userName;
	}

}
