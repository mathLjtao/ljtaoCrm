package com.service;

import com.dao.UserDao;
import com.dao.impl.UserDaoImpl;
import com.domain.User;

public interface UserService {
	public User login(User user) throws Exception;

}
