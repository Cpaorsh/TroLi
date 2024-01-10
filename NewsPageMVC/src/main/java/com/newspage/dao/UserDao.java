package com.newspage.dao;

import com.newspage.beans.Login;
import com.newspage.beans.User;

public interface UserDao {

  //int register(User user);

  User validateUser(Login login);
  
  User getUserById(String max);
  
  int changePassword (User user);
}
