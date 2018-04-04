package com.han.rm.spring;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;
import org.junit.Test;

public class SpringTest
{
	@Test
	public void testSpringCtx() throws FileNotFoundException, IOException
	{

		byte[] arr = IOUtils.toByteArray(new FileInputStream(new File("src/test/resources/application.xml")));

		byte[] arrProps = IOUtils
				.toByteArray(new FileInputStream(new File("src/test/resources/spring-config.properties")));
		@SuppressWarnings("resource")
		DefaultSpringApplicationContext ctx = new DefaultSpringApplicationContext(arr, arrProps);

		UserMapper userMapper = ctx.getBean(UserMapper.class);

		User user = new User();
		user.setUserName("lisi2");

		user = userMapper.loadUser(user);

		System.out.println(user.toString());

		user = userMapper.findUser(6);

		System.out.println(user.toString());

		User u = new User();
		u.setUserName("liyang");
		u.setUserPassword("666");

		UserService userService = ctx.getBean(UserService.class);
		System.out.println(userService.addUser(u));

		System.out.println(userMapper.getUserName(6));

	}

}
