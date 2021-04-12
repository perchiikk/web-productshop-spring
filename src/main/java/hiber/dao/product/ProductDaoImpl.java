package hiber.dao.product;


import hiber.model.sql.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductDaoImpl implements ProductDao{
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void add(Product product) {
        sessionFactory.getCurrentSession().save(product);
    }

    @Override
    public Product getById(Integer id) {
        TypedQuery<Product> query = sessionFactory.getCurrentSession().createQuery("from Product where id = :id");
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void removeByid(Integer id) {
        Product product = getById(id);
        sessionFactory.getCurrentSession().delete(product);
    }

    @Override
    public void update(Product product) {
        sessionFactory.getCurrentSession().update(product);
    }

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = sessionFactory.getCurrentSession().createQuery("from Product");
        return query.getResultList();
    }

    @Override
    public Product searchByName(String name) {
        TypedQuery<Product> query = sessionFactory.getCurrentSession().createQuery("from Product where name = :name");
        query.setParameter("name", name);
        return query.getSingleResult();
    }
}
