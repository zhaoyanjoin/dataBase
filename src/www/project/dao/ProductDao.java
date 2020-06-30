package www.project.dao;

import www.project.bean.Product;

import java.util.List;

public interface ProductDao {
   List<Product> findYouXuanProduct();//查询优选商品
   List<Product> findReMenProduct();//查询热门商品
   Product findProductById(int id);
}
