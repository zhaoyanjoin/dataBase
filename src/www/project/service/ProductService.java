package www.project.service;

import www.project.bean.Product;

import java.util.List;

public interface ProductService {
    List<Product> findYouXuanProduct();
    List<Product> findReMenProduct();
    Product findProductById(int pro_id);
}
