package hiber.service.listoforder;

import hiber.dao.listoforder.ListOfOrderDao;
import hiber.model.sql.ListOfOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ListOfOrderServiceImpl implements ListOfOrderService{
    private ListOfOrderDao listOfOrderDao;

    @Autowired
    public ListOfOrderServiceImpl(ListOfOrderDao listOfOrderDao) {
        this.listOfOrderDao = listOfOrderDao;
    }

    @Transactional
    @Override
    public void add(ListOfOrder listOfOrder) {
        listOfOrderDao.add(listOfOrder);
    }

    @Transactional
    @Override
    public ListOfOrder getById(Integer id) {
        return listOfOrderDao.getById(id);
    }

    @Transactional
    @Override
    public void removeByid(Integer id) {
        listOfOrderDao.removeByid(id);
    }

    @Transactional
    @Override
    public void update(ListOfOrder listOfOrder) {
        listOfOrderDao.update(listOfOrder);
    }

    @Transactional
    @Override
    public List<ListOfOrder> getAll() {
        return listOfOrderDao.getAll();
    }

    @Override
    public List<ListOfOrder> getListByOrderId(Integer id) {
        return listOfOrderDao.getListByOrderId(id);
    }
}
