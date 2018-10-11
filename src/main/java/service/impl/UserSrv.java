package service.impl;

import pojo.User;
import repository.iface.IUserDao;
import repository.impl.UserDao;
import service.iface.IUserSrv;

import java.util.List;

public class UserSrv implements IUserSrv {
    private IUserDao userDao;

    public UserSrv() {
        this.userDao = new UserDao();
    }

    public UserSrv(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean add(User user) {
        return userDao.add(user);
    }

    @Override
    public User getById(Integer id) {
        return userDao.getById(id);
    }

    @Override
    public User getByLogin(String login) {
        return userDao.getByLogin(login);
    }

    @Override
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Override
    public boolean update(User user) {
        return userDao.update(user);
    }
}
