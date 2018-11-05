package com.dao;

import com.domain.User;

public interface UserDao {
	//根据用户输入的user信息，查询数据库中的user
	public User login(User user);
	

}
