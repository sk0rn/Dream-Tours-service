package repository.iface;

//просто для примера
public interface IUserDao {

    User get(Integer id);

    User[] getAll();

    boolean set(User user, boolean updatePojo);
}
