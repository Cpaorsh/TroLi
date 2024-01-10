package com.newspage.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.newspage.dao.UserDao;
import com.newspage.beans.Login;
import com.newspage.beans.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

//  public int register(User user) {
//    return userDao.register(user);
//  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }
  
  public User getUserById(String max) {
  	return userDao.getUserById(max);
  }
  
  public int changePassword (User user) {
	return userDao.changePassword(user);  
  }
  

}
