package www.project.serviceImpl;

import www.project.bean.Product;
import www.project.dao.ProductDao;
import www.project.daoImpl.ProductDaoImpl;
import www.project.service.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductDao pd = new ProductDaoImpl();
    @Override
    public List<Product> findYouXuanProduct() {

        return pd.findYouXuanProduct();
    }

    @Override
    public List<Product> findReMenProduct() {
        return pd.findYouXuanProduct();
    }

    @Override
    public Product findProductById(int pro_id) {
        return pd.findProductById(pro_id);
    }
}
