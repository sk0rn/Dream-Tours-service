package repository.impl;

import pojo.Order;
import repository.background.DaoBackground;
import repository.iface.IOrderDao;

public class OrderDao implements IOrderDao {
    private static final DaoBackground<Order> background = new DaoBackground<>(Order::new,
            Order[]::new,
            Order::init);

    @Override
    public boolean add(Order order) {
        return background.execute("INSERT INTO orders VALUES (Default, ?, ?, ?, ?)",
                order.getUserId(), order.getTourReleaseId(), order.getCoast(), order.getStatus());
    }

    @Override
    public Order getById(Integer id) {
        return background.fetchOneRowAsPojoObject("select * from orders where id = ?", id);
    }

    @Override
    public boolean update(Order order) {
        return background.execute("Update orders SET user_id=?, tour_release_id=?, coast=?,\n" +
                        "  status=? where id=?", order.getUserId(), order.getTourReleaseId(),
                order.getCoast(), order.getStatus(), order.getId());
    }
}
