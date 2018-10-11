package repository.impl;

import pojo.User;
import repository.background.DaoBackground;
import repository.iface.IUserDao;

import java.util.List;

public class UserDao implements IUserDao {
    private final static DaoBackground<User> background = new DaoBackground<>(User::new,
            User[]::new,
            User::init);

    @Override
    public boolean add(User user) {
        return background.execute("INSERT INTO users VALUES (Default, ?, ?, ?, ?, ?, ?, ?, ?)",
                user.getLogin(), user.getPassword(), user.getOption(), user.getFio(), user.getCallTime(),
                user.getSubscribe(), user.getBonus(), user.getAlbumGuid());

    }

    @Override
    public User getById(Integer id) {
        return background.fetchOneRowAsPojoObject("select * from users where id = ?", id);
    }

    @Override
    public User getByLogin(String login) {
        return background.fetchOneRowAsPojoObject("select * from users where login = ?", login);
    }

    @Override
    public List<User> getAll() {
        return background.fetchRowsAsPojoList("select * from users");
    }

    @Override
    public boolean update(User user) {
        return background.execute("Update users SET login=?, pass=?, options=?,\n" +
                "  fio=?, call_time=?,subscribe=?,\n" +
                "  bonus=?, album_guid=? where id=?", user.getLogin(), user.getPassword(),
                user.getOption(), user.getFio(), user.getCallTime(), user.getSubscribe(),
                user.getBonus(), user.getAlbumGuid(), user.getId());
    }
}
