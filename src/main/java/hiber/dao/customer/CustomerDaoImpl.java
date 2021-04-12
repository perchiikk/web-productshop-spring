package hiber.dao.customer;

import hiber.model.sql.Customer;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao{
    private SessionFactory sessionFactory;

    @Autowired
    public CustomerDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void add(Customer customer) {
        sessionFactory.getCurrentSession().save(customer);
    }

    @Override
    public Customer getById(Integer id) {
        TypedQuery<Customer> query = sessionFactory.getCurrentSession().createQuery("FROM  Customer where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void removeByid(Integer id) {
        Customer customer = getById(id);
        sessionFactory.getCurrentSession().delete(customer);
    }

    @Override
    public void update(Customer customer) {
        sessionFactory.getCurrentSession().update(customer);
    }

    @Override
    public List<Customer> getAll() {
        TypedQuery<Customer> query = sessionFactory.getCurrentSession().createQuery("from Customer ");
        return query.getResultList();
    }

    @Override
    public Customer getLast() {
        return getAll().get(getAll().size() - 1);
    }


}
