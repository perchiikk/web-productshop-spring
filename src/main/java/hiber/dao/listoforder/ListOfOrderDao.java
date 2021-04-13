package hiber.dao.listoforder;

import hiber.model.sql.ListOfOrder;


import java.util.List;

public interface ListOfOrderDao {
    void add(ListOfOrder listOfOrder);

    ListOfOrder getById(Integer id);

    void removeByid(Integer id);

    void update(ListOfOrder listOfOrder);

    List<ListOfOrder> getAll();

    List<ListOfOrder> getListByOrderId(Integer id);
}
