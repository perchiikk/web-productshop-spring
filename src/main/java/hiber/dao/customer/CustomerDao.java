package hiber.dao.customer;

import hiber.model.sql.Customer;

import java.util.List;

public interface CustomerDao {

    void add(Customer customer);

    void removeByid(Integer id);

    Customer getById(Integer id);

    void update(Customer customer);

    List<Customer> getAll();

    Customer getLast();
}
