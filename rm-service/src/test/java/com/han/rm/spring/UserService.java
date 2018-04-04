package com.han.rm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService
{

	@Autowired
	private UserMapper userMapper;

	@Transactional
	public int addUser(User user)
	{
		int a = userMapper.insertUser(user);

		int b = a / 0;

		return a;
	}

}
