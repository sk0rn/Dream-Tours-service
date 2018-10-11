package service.account;

public interface ILoginService {

    Integer getRole(String login);

    boolean checkAuth(String login, String password);

}
