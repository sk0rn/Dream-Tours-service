package repository.iface;

import pojo.User;

//просто для примера
public interface IUserDao {

    boolean add(User user);

    User getById(Integer id);

    User getByLogin(String login);

    User[] getAll();

    boolean update(User user);
}
