package controller.admin;

import service.iface.*;
import service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class AddContentServlet extends HttpServlet {
    private IPlaceSrv placeSrv;
    private ISubjectSrv subjectSrv;
    private ITourCoastSrv tourCoastSrv;
    private ITourDurationSrv tourDurationSrv;
    private ITourPlaceSrv tourPlaceSrv;
    private ITourReleaseSrv tourReleaseSrv;
    private ITourSubjectSrv tourSubjectSrv;
    private ITourSrv tourSrv;

    @Override
    public void init() throws ServletException {
        super.init();
        placeSrv = new PlaceSrv();
        subjectSrv = new SubjectSrv();
        tourCoastSrv = new TourCoastSrv();
        tourDurationSrv = new TourDurationSrv();
        tourPlaceSrv = new TourPlaceSrv();
        tourReleaseSrv = new TourReleaseSrv();
        tourSubjectSrv = new TourSubjectSrv();
        tourSrv = new TourSrv();
    }
}
