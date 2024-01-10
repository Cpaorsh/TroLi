package com.newspage.service;

import com.newspage.beans.Login;
import com.newspage.beans.User;

public interface UserService {

  //int register(User user);

  User validateUser(Login login);
  
  User getUserById(String max);
  
  int changePassword (User user);
}
