package controller.customer;

import service.impl.OrderSrv;
import service.impl.UserSrv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class CustomerServlet extends HttpServlet {
    private UserSrv userSrv;
    private OrderSrv orderSrv;

    @Override
    public void init() throws ServletException {
        super.init();
        userSrv = new UserSrv();
        orderSrv = new OrderSrv();
    }
}
