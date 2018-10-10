package repository.iface;

import pojo.TourRelease;

import java.util.List;

public interface ITourReleaseDao {

    boolean add(TourRelease tourRelease);

    TourRelease getById(Integer id);

    List<TourRelease> getAllByTourId(Integer tourid);

    boolean updateById(TourRelease tourRelease);

    boolean deleteById(Integer id);
}
