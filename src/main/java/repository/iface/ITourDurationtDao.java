package repository.iface;

import pojo.TourDuration;

import java.util.List;

public interface ITourDurationtDao {

    boolean add(TourDuration tourDuration);

    TourDuration getById(Integer id);

    List<TourDuration> getAllByTourId(Integer tourd);

    boolean updateById(TourDuration tourDuration);

    boolean deleteById(Integer id);

    public List<TourDuration> getAll();
}
