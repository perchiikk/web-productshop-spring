package hiber.service.customer;

import hiber.dao.customer.CustomerDao;
import hiber.model.sql.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    private CustomerDao customerDao;


    @Autowired
    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Transactional
    @Override
    public void add(Customer customer) {
        customerDao.add(customer);
    }

    @Transactional
    @Override
    public void removeByid(Integer id) {
        customerDao.removeByid(id);
    }

    @Transactional
    @Override
    public Customer getById(Integer id) {
        return customerDao.getById(id);
    }

    @Transactional
    @Override
    public void update(Customer customer) {
        customerDao.update(customer);
    }

    @Transactional
    @Override
    public List<Customer> getAll() {
        return customerDao.getAll();
    }

    @Transactional
    @Override
    public Customer getLast() {
        return customerDao.getLast();
    }
}
