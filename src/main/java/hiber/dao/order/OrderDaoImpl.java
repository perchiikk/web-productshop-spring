package hiber.dao.order;

import hiber.model.sql.Order;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao{
    private SessionFactory sessionFactory;

    @Autowired
    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(Order order) {
        sessionFactory.getCurrentSession().save(order);
    }

    @Override
    public Order getById(Integer id) {
        TypedQuery<Order> query = sessionFactory.getCurrentSession().createQuery("from Order where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void removeByid(Integer id) {
        Order order = getById(id);
        sessionFactory.getCurrentSession().delete(order);
    }

    @Override
    public void update(Order order) {
        sessionFactory.getCurrentSession().update(order);
    }

    @Override
    public List<Order> getAll() {
        TypedQuery<Order> query = sessionFactory.getCurrentSession().createQuery("from Order");
        return query.getResultList();
    }

    @Override
    public List<Order> getByCustomerId(Integer id) {

        /*TypedQuery<Order> query = sessionFactory.getCurrentSession().createQuery("from Order where 'customer_id' = :id");
        query.setParameter("id", id);
        return query.getResultList();*/
        List<Order> result = new ArrayList<>();
        List<Order> listAll = getAll();
        for(Order order : listAll){
            if(order.getCustomer().getId() == id){
                result.add(order);
            }
        }
        return result;
    }
}
