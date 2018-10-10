package repository.iface;

import pojo.Order;

public interface IOrderDao {

    boolean add(Order order);

    Order getById(Integer id);

    boolean update(Order user);
}