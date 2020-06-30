package www.project.serviceImpl;

import www.project.bean.User;
import www.project.daoImpl.UserDaoImpl;
import www.project.service.UserService;

public class UserServiceImpl implements UserService {

    @Override
    public int addUser(User user) {
        return new UserDaoImpl().insertUser(user);
    }

    @Override
    public User checkUser(String username, String password) {
        return  new UserDaoImpl().findUser(username,password);
    }
}
