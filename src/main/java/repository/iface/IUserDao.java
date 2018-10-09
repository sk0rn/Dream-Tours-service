package repository.iface;

import pojo.User;

//просто для примера
public interface IUserDao {

    User get(Integer id);

    User[] getAll();

    boolean set(User user, boolean updatePojo);
}
