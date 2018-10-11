package service.tour.iface;

import pojo.Tour;

import java.util.List;

public interface ITourSrv {

    boolean add(Tour tour);

    Tour getById(Integer id);

    List<Tour> getAll();

    List<Tour> getBySubjectId(Integer subjectId);

    List<Tour> getByClientId(Integer clientId);

    List<Tour> getByOrderId(Integer orderId);

    boolean update(Tour tour);

    boolean deleteById(Integer id);
}
