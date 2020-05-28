package org.randy.domain.root;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.randy.domain.user.root.GraduatedException;
import org.randy.domain.user.root.SameNameException;
import org.randy.domain.user.root.User;

/**
 * User聚合单元测试
 * 
 * @author x00418543
 * @since 2019年12月17日
 */
public class UserTest {

	private User user;

	@Before
	public void setUp() {
		user = User.with(1, "xiangyang", "xiangyang123", false).contactWith("xiangyang@huawei.com");
	}

	@After
	public void tearDown() {
		user = null;
	}

	@Test
	public void test_should_rename() throws SameNameException, GraduatedException {
		user.rename("zhangzhi");
		assertEquals("zhangzhi", user.getUsername());
	}

	@Test(expected = GraduatedException.class)
	public void test_should_throw_GraduatedException_when_rename_graduated_user()
			throws SameNameException, GraduatedException {
		user.graduate();
		user.rename("xiangyang");
	}

	@Test(expected = SameNameException.class)
	public void test_should_throw_SameNameException_when_rename_xiangyang()
			throws SameNameException, GraduatedException {
		user.rename("xiangyang");
	}

	@Test
	public void test_should_success_when_graduate_user() throws GraduatedException {
		user.graduate();
		assertTrue(user.isGraduated());
	}

	@Test(expected = GraduatedException.class)
	public void test_should_throw_GraduatedException_when_graduate_user_twice() throws GraduatedException {
		user.graduate();
		user.graduate();
	}

}
