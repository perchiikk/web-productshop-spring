package hiber.service.shopmanager;


import hiber.model.sql.Product;
import java.util.Map;

public interface ShopManagerService {
    Map<Product, Integer> getOrder();

    void addToItem(Product product, Integer count);

    Integer getPayment();

    void deleteByName(Product product);

    void cleanOrderCart();
}
