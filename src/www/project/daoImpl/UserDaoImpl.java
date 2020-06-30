package www.project.daoImpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import www.project.bean.User;
import www.project.dao.UserDao;
import www.project.utils.C3P0Utils;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public int insertUser(User user) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into User values (null,?,?,?,?,?,?)";
        int num = 0;
        try {
           num=qr.update(sql,new Object []{user.getUsername(),user.getPassword(),user.getEmail(),user.getName(),user.getSex(),user.getBirthday()});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return num;
    }


    public User findUser(String username, String password) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from user where username=? and password=?";
        User user=null;
        try {
            user = qr.query(sql,new BeanHandler<>(User.class),new Object[]{username,password});
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }
}
