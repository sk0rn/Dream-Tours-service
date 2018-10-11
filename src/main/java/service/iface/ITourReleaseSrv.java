package service.iface;

import pojo.TourRelease;

import java.util.List;

public interface ITourReleaseSrv {

    boolean add(TourRelease tourRelease);

    TourRelease getById(Integer id);

    List<TourRelease> getAllByTourId(Integer tourId);

    boolean updateById(TourRelease tourRelease);

    boolean deleteById(Integer id);
}
