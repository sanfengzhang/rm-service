package com.han.rm.spring;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper
{
	@Select("select * from t_user where user_name=#{userName}")
	public User loadUser(User user);

	// 在使用getter/setter设置属性的时候尽量只取用到的属性，这样可以降低部分性能损耗
	@Select("select user_name from t_user where id=#{id}")
	public User findUser(int id);

	@Insert("insert into t_user(user_name,user_password) values (#{userName},#{userPassword} )")
	public int insertUser(User user);

	@Select("select user_name from t_user where id=#{id}")
	public String getUserName(int id);
}
