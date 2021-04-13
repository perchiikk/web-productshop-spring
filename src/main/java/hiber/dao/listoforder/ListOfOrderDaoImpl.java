package hiber.dao.listoforder;

import hiber.model.sql.ListOfOrder;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ListOfOrderDaoImpl implements ListOfOrderDao{
    private SessionFactory sessionFactory;

    @Autowired
    public ListOfOrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(ListOfOrder listOfOrder) {
        sessionFactory.getCurrentSession().save(listOfOrder);
    }

    @Override
    public ListOfOrder getById(Integer id) {
        TypedQuery<ListOfOrder> query = sessionFactory.getCurrentSession().createQuery("from ListOfOrder where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void removeByid(Integer id) {
        ListOfOrder listOfOrder = getById(id);
        sessionFactory.getCurrentSession().delete(listOfOrder);
    }

    @Override
    public void update(ListOfOrder listOfOrder) {
        sessionFactory.getCurrentSession().update(listOfOrder);
    }

    @Override
    public List<ListOfOrder> getAll() {
        TypedQuery<ListOfOrder> query = sessionFactory.getCurrentSession().createQuery("from ListOfOrder");
        return query.getResultList();
    }

    @Override
    public List<ListOfOrder> getListByOrderId(Integer id) {
        TypedQuery<ListOfOrder> query = sessionFactory.getCurrentSession().createQuery("from ListOfOrder where order.id = :id");
        query.setParameter("id", id);
        return query.getResultList();
    }
}
