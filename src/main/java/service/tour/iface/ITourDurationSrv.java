package service.tour.iface;

import pojo.TourDuration;

import java.util.List;

public interface ITourDurationSrv {

    boolean add(TourDuration tourDuration);

    TourDuration getById(Integer id);

    List<TourDuration> getAllByTourId(Integer tourId);

    boolean updateById(TourDuration tourDuration);

    boolean deleteById(Integer id);
}
