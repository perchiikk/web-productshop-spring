package hiber.service.listoforder;

import hiber.model.sql.ListOfOrder;

import java.util.List;

public interface ListOfOrderService {
    void add(ListOfOrder listOfOrder);

    ListOfOrder getById(Integer id);

    void removeByid(Integer id);

    void update(ListOfOrder listOfOrder);

    List<ListOfOrder> getAll();
}
