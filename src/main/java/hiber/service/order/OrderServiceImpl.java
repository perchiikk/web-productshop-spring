package hiber.service.order;

import hiber.dao.order.OrderDao;
import hiber.model.sql.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class OrderServiceImpl implements OrderService{
    private OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Transactional
    @Override
    public void add(Order order) {
        orderDao.add(order);
    }

    @Transactional
    @Override
    public Order getById(Integer id) {
        return orderDao.getById(id);
    }

    @Transactional
    @Override
    public void removeByid(Integer id) {
        orderDao.removeByid(id);
    }

    @Transactional
    @Override
    public void update(Order order) {
        orderDao.update(order);
    }

    @Transactional
    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Transactional
    @Override
    public Order getByCustomerId(Integer id) {
        return orderDao.getByCustomerId(id);
    }
}
