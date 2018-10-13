package controller;

import pojo.Contact;
import pojo.User;
import service.user.impl.ContactSrv;
import service.user.impl.UserSrv;
import utils.CheckUserData;
import utils.UtilMD5;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private UserSrv userSrv;
    private ContactSrv contactSrv;

    @Override
    public void init() throws ServletException {
        super.init();
        userSrv = new UserSrv();
        contactSrv = new ContactSrv();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("allRequestsAnswer", "/register");
        req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("pass");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        if (userSrv.getByLogin(login) == null) {
            if (CheckUserData.checkPassword(pass, 8, 2, 2, 2)) {
                if (CheckUserData.checkPhone(phone, 11)) {
                    User user = new User(null, login, UtilMD5.md5Custom(pass), 0, null, null, false, 0.0, null);
                    userSrv.add(user);
                    int userId = userSrv.getByLogin(login).getId();
                    Contact contactPhone = new Contact(null, userId, "phone:" + phone);
                    Contact contactEmail = new Contact(null, userId, "email:" + email);
                    contactSrv.add(contactPhone);
                    contactSrv.add(contactEmail);
                    resp.sendRedirect("/?infoCode=okRegister");
                } else {
                    resp.sendRedirect("/register?errorCode=errPhone");
                }
            } else {
                resp.sendRedirect("/register?errorCode=errPass");
            }
        } else {
            resp.sendRedirect("/register?errorCode=errLogin");
        }
    }
}
