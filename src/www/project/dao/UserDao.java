package www.project.dao;

import www.project.bean.User;

public interface UserDao {
    int insertUser(User user);
    User findUser(String username,String password);


}

