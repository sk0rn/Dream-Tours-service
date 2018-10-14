package controller.customer;

import service.user.impl.OrderSrv;
import service.user.impl.UserSrv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomerServlet extends HttpServlet {
    private UserSrv userSrv;
    private OrderSrv orderSrv;

    @Override
    public void init() throws ServletException {
        super.init();
        userSrv = new UserSrv();
        orderSrv = new OrderSrv();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/indexCustomer.jsp").forward(req, resp);
    }
}
