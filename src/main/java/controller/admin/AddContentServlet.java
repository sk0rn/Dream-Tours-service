package controller.admin;

import pojo.*;
import service.tour.iface.*;
import service.tour.impl.*;
import service.util.impl.AlbumSrv;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.UUID;

@MultipartConfig
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
        //Получаем id со странице туров (после нажатия на кнопку "Изменить")
        String id = req.getParameter("id");
        if (id != null) {
            int idTour = Integer.parseInt(id);
            Tour tour = tourSrv.getById(idTour);
            req.setAttribute("update", "true");
            req.setAttribute("tourUpdate", tour);
        }
        req.getRequestDispatcher("/jsp/indexAdmin.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String name = req.getParameter("tourName");
        if (name != null) {
            String id = req.getParameter("idTour");
            String desc = req.getParameter("descTour");
            String youtubeUrl = req.getParameter("youtubeUrl");
            String albumGuid = UUID.randomUUID().toString();
            Part filePart = req.getPart("imageTour");
            InputStream fileContent = filePart.getInputStream();
            AlbumSrv.writeFile(fileContent, albumGuid, filePart.getSubmittedFileName());
            if (!"".equals(id)) {
                Tour tour = new Tour(Integer.parseInt(id),
                        name,
                        tourSrv.getById(Integer.parseInt(id)).getAlbumGuid(),
                        youtubeUrl,
                        desc);
                tourSrv.update(tour);
                req.setAttribute("idTour", "");
            } else {
                Tour tour = new Tour(null, name, albumGuid, youtubeUrl, desc);
                tourSrv.add(tour);
            }
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

        String timestamp = req.getParameter("dateStart");
        if (timestamp != null) {
            String tourId = req.getParameter("tourList");
            String tourDurationId = req.getParameter("tourDurationList");
            String capacity = req.getParameter("capacity");
            TourRelease tourRelease = new TourRelease(null, Integer.parseInt(tourId),
                    Integer.parseInt(tourDurationId),
                    Timestamp.valueOf(timestamp.replace("T", " ") + ":00"),
                    Integer.parseInt(capacity));
            tourReleaseSrv.add(tourRelease);
        }

        String coast = req.getParameter("tourCoast");
        if (coast != null) {
            String tourDurationId = req.getParameter("tourDurationList");
            String kindJsp = req.getParameter("kind");
            Boolean kind = false;
            if ("перелет".equals(kindJsp)) {
                kind = true;
            }
            String clippingAge = req.getParameter("clippingAge");
            String isParticipantJsp = req.getParameter("isParticipant");
            Boolean isParticipan = false;
            if ("on".equals(isParticipantJsp)) {
                isParticipan = true;
            }
            TourCoast tourCoast = new TourCoast(null,
                    Integer.parseInt(tourDurationId),
                    kind,
                    Double.parseDouble(coast),
                    Integer.parseInt(clippingAge),
                    isParticipan);
            tourCoastSrv.add(tourCoast);
        }

        resp.sendRedirect("/admin/add_content");
    }
}
