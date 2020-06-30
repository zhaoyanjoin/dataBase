package www.project.daoImpl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import www.project.bean.Product;
import www.project.dao.ProductDao;
import www.project.utils.C3P0Utils;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public List<Product> findYouXuanProduct() {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from Product where pro_state=2";
        List<Product>  list = null;
       try {
          list =  qr.query(sql,new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Product> findReMenProduct() {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from Product where pro_state=1";
        List<Product>  list = null;
        try {
            list =  qr.query(sql,new BeanListHandler<>(Product.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Product findProductById(int pro_id) {
        QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "select * from product where pro_id=?";
        Product product= null ;
        try {
             product = qr.query(sql,new BeanHandler<>(Product.class),pro_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product;
    }
}
