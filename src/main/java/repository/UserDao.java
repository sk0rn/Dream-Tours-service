package repository;

import pojo.User;
import repository.background.DaoBackground;
import repository.iface.IUserDao;


public class UserDao implements IUserDao {
    private final static DaoBackground<User> background = new DaoBackground<>(User::new,
            User[]::new,
            User::init);

    @Override
    public User get(Integer id) {
        return background.fetchOneRowAsPojoObject("select * from users where id = ?", id);
    }

    @Override
    public boolean set(User user, boolean updatePojo) {
        //param updatePojo unused in this example
        return background.execute("update users set login=?, pass=?,option=?, fio=?, call_time=?, subscribe=? where id=?", user.getLogin(), user.getOption());
    }

    @Override
    public User[] getAll() {
        return background.fetchRowsAsPojoArray("select * from users");
    }

}
