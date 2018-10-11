package service.account;

import org.apache.log4j.Logger;
import pojo.User;
import repository.iface.IUserDao;
import repository.impl.UserDao;
import utils.UtilMD5;

import java.sql.SQLException;

public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = Logger.getLogger(LoginServiceImpl.class);
    private IUserDao userDao;

    public LoginServiceImpl() {
        userDao = new UserDao();
    }

    public LoginServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * @return null if user not found or exception,
     * 0 if client,
     * 1 if employee
     * */
    @Override
    public Integer getRole(String login) {
        User user;
        if (login != null) {
            user = userDao.getByLogin(login);
            if (user == null) return null;
            return user.getOption();
        }
        return -1;
    }

    @Override
    public boolean checkAuth(String login, String password) {
        User user;
        if (login != null && password != null) {
            user =  userDao.getByLogin(login);
            if (user != null) {
                return user.getPassword().equals(UtilMD5.md5Custom(password));
            } else {
                return false;
            }
        }
        return false;
    }

}
