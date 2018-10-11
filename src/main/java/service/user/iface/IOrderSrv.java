package service.user.iface;

import pojo.Order;

public interface IOrderSrv {

    boolean add(Order order);

    Order getById(Integer id);

    boolean update(Order order);
}