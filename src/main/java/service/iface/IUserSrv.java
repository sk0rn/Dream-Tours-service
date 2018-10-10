package service.iface;

import pojo.User;

import java.util.List;

public interface IUserSrv {

    boolean add(User user);

    User getById(Integer id);

    User getByLogin(String login);

    List<User> getAll();

    boolean update(User user);
}
