package controller.admin;

import pojo.*;
import service.tour.iface.*;
import service.tour.impl.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("tours", tourSrv.getAll());
        req.setAttribute("tourDuration", tourDurationSrv.getAll());
        req.getRequestDispatcher("/jsp/indexAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("tourName");
        if (name != null) {
            String albumGuid = req.getParameter("imageTour");
            String youtubeUrl = req.getParameter("youtubeUrl");
            String desc = req.getParameter("descTour");
            Tour tour = new Tour(null, name, albumGuid, youtubeUrl, desc);
            tourSrv.add(tour);
        }

        String placeName = req.getParameter("placeName");
        if (placeName != null) {
            String descPlace = req.getParameter("descPlace");
            Place place = new Place(null, placeName, descPlace);
            placeSrv.add(place);
        }

        String subjectName = req.getParameter("subjectName");
        if (subjectName != null) {
            String descSubject = req.getParameter("descSubject");
            Subject subject = new Subject(null, subjectName, descSubject);
            subjectSrv.add(subject);
        }

        String numberDays = req.getParameter("numberDays");
        if (numberDays != null) {
            String descDuration = req.getParameter("descDuration");
            TourDuration tourDuration = new TourDuration(null, Integer.parseInt(numberDays), descDuration);
            tourDurationSrv.add(tourDuration);
        }

        String timestamp = req.getParameter("dateStart").replace("T", " ") + ":00";
        if (timestamp != null) {
            String tourId = req.getParameter("tourList");
            String tourDurationId = req.getParameter("tourDurationList");
            String capacity = req.getParameter("capacity");
            TourRelease tourRelease = new TourRelease(null, Integer.parseInt(tourId),
                    Integer.parseInt(tourDurationId),
                    Timestamp.valueOf(timestamp),
                    Integer.parseInt(capacity));
            tourReleaseSrv.add(tourRelease);
        }

        /*String tourCoast = req.getParameter("tourCoast");
        if(tourCoast != null) {
            String tourDurationId = req.getParameter("tourDurationList");
            String capacity = req.getParameter("capacity");
            TourRelease tourRelease = new TourRelease(null, Integer.parseInt(tourId),
                    Integer.parseInt(tourDurationId),
                    Timestamp.valueOf(timestamp),
                    Integer.parseInt(capacity));
            tourReleaseSrv.add(tourRelease);
        }*/

        resp.sendRedirect("/admin/add_content");
    }
}
