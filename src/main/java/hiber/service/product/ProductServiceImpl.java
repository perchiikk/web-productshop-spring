package hiber.service.product;

import hiber.dao.product.ProductDao;
import hiber.model.sql.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{
    private ProductDao productDao;

    @Autowired
    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Transactional
    @Override
    public void add(Product product) {
        productDao.add(product);
    }

    @Transactional
    @Override
    public Product getById(Integer id) {
        return productDao.getById(id);
    }

    @Transactional
    @Override
    public void removeByid(Integer id) {
        productDao.removeByid(id);
    }

    @Transactional
    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Transactional
    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Transactional
    @Override
    public Product searchByName(String name) {
        return productDao.searchByName(name);
    }
}
