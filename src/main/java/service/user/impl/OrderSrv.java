package service.user.impl;

import pojo.Order;
import repository.iface.IOrderDao;
import repository.impl.OrderDao;
import service.user.iface.IOrderSrv;

public class OrderSrv implements IOrderSrv {
    private IOrderDao orderDao;

    public OrderSrv() {
        this.orderDao = new OrderDao();
    }

    public OrderSrv(IOrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public boolean add(Order order) {
        return orderDao.add(order);
    }

    @Override
    public Order getById(Integer id) {
        return orderDao.getById(id);
    }

    @Override
    public boolean update(Order order) {
        return orderDao.update(order);
    }
}
