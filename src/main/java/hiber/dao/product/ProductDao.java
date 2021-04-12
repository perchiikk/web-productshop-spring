package hiber.dao.product;

import hiber.model.sql.Product;

import java.util.List;

public interface ProductDao {
    void add(Product product);

    Product getById(Integer id);

    void removeByid(Integer id);

    void update(Product product);

    List<Product> getAll();

    Product searchByName(String name);
}
