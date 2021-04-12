package hiber.service.order;

import hiber.model.sql.Order;

import java.util.List;

public interface OrderService {
    void add(Order order);

    Order getById(Integer id);

    void removeByid(Integer id);

    void update(Order order);

    List<Order> getAll();

    Order getByCustomerId(Integer id);
}
