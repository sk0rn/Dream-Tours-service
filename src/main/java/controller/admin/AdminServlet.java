package controller.admin;

import service.impl.OrderSrv;
import service.impl.UserSrv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AdminServlet extends HttpServlet {
    private OrderSrv orderSrv;
    private UserSrv userSrv;

    @Override
    public void init() throws ServletException {
        super.init();
        orderSrv = new OrderSrv();
        userSrv = new UserSrv();
    }
}
