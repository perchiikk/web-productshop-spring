package hiber.service.shopmanager;

import hiber.model.sql.Product;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class ShopManagerServiceImpl implements ShopManagerService{

    private static Map<Product, Integer> orderMap = new HashMap<>();

    @Override
    public Map<Product, Integer> getOrder() {
        return orderMap;
    }

    @Override
    public void addToItem(Product product, Integer count) {
        orderMap.put(product, count);
    }

    @Override
    public Integer getPayment() {
        int result = 0;
        for(Map.Entry<Product, Integer> entry : orderMap.entrySet()){
            int sum = entry.getKey().getPrice() * entry.getValue();
            result += sum;
        }
        return result;
    }

    @Override
    public void deleteByName(Product product) {
        if(orderMap.containsKey(product)){
            orderMap.remove(product);
        }
        else{
            System.out.println("error");
        }
    }

    @Override
    public void cleanOrderCart() {
        orderMap.clear();
    }
}
