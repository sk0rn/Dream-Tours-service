package controller;

import service.account.ILoginService;
import service.account.LoginService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static constants.Consts.LOGIN;

public class LoginServlet extends HttpServlet {
    private ILoginService loginService;

    @Override
    public void init() throws ServletException {
        super.init();
        loginService = new LoginService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // выход
        if ("logout".equals(req.getParameter("action"))) {
            req.getSession().invalidate();
        }
        // если уже залогинены
        if (req.getSession().getAttribute(LOGIN) != null) {
            resp.sendRedirect("/tours");
        } else {
            req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String login = req.getParameter(LOGIN);
        String password = req.getParameter("password");
        if (loginService.checkAuth(login, password)) {
            Integer role = loginService.getRole(login);
            req.getSession().setAttribute(LOGIN, login);
            req.getSession().setAttribute("option", role);
            System.out.println(role);
            resp.sendRedirect("/tours");
        } else {
            // если логин не найден
            resp.sendRedirect("/?errorCode=wrongLogin");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
