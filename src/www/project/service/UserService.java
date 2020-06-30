package www.project.service;

import www.project.bean.User;

public interface UserService {
   int addUser(User user);//增加用户
   User checkUser(String username,String password);
}
