package org.randy.domain.user.eventlisteners;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.randy.domain.core.event.DomainEvent;
import org.randy.domain.core.event.DomainEventListener;
import org.randy.domain.user.events.UserGraduatedEvent;
import org.randy.domain.user.events.UserRenamedEvent;
import org.springframework.transaction.annotation.Transactional;

/**
 * 用户事件监听
 * 
 * @author x00418543
 * @since 2019年12月4日
 */
public class UserEventListener implements DomainEventListener {

	@Transactional
	@Override
	public void handle(DomainEvent event) {
		if (event instanceof UserGraduatedEvent) {
			onUserGraduated((UserGraduatedEvent) event);
		} else if (event instanceof UserRenamedEvent) {
			onUserRenamed((UserRenamedEvent) event);
		}
	}

	public void onUserGraduated(UserGraduatedEvent event) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("ID为：" + event.getUserId() + "的User于" + df.format(event.occurredOn()) + "毕业了");
	}

	public void onUserRenamed(UserRenamedEvent event) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(
				"ID为：" + event.getUserId() + "的User在" + df.format(event.occurredOn()) + "改名为：" + event.getNameAfter());
	}

}
