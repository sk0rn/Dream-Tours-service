package controller.content;

import service.tour.impl.TourSrv;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class TourDetails extends HttpServlet {
    private TourSrv tourSrv;

    @Override
    public void init() throws ServletException {
        super.init();
        tourSrv = new TourSrv();
    }
}
