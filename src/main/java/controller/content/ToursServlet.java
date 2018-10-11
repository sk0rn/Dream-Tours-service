package controller.content;

import service.tour.impl.SubjectSrv;
import service.tour.impl.TourSrv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ToursServlet extends HttpServlet {
    private TourSrv tourSrv;
    private SubjectSrv subjectSrv;

    @Override
    public void init() throws ServletException {
        super.init();
        tourSrv = new TourSrv();
        subjectSrv = new SubjectSrv();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("allRequestsAnswer", "/tours");
        req.setAttribute("subjects", subjectSrv.getAll());
        req.getRequestDispatcher("/jsp/index.jsp").forward(req, resp);
    }
}
