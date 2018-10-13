package controller.content;

import pojo.TourExtend;
import service.tour.impl.TourExtendSrv;
import service.tour.iface.ITourExtendSrv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ToursServlet extends HttpServlet {
    private ITourExtendSrv tourExtendSrv;

    @Override
    public void init() throws ServletException {
        super.init();
        tourExtendSrv = new TourExtendSrv();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TourExtend> tours = tourExtendSrv.getAll();
        req.setAttribute("tours", tours);
        req.getRequestDispatcher("/jsp/indexTours.jsp").forward(req, resp);
    }
}
