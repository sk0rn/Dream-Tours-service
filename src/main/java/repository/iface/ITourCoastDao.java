package repository.iface;

import pojo.TourCoast;

import java.util.List;

public interface ITourCoastDao {

    boolean add(TourCoast tourCoast);

    List<TourCoast> getAllByTourDuration(Integer tourDurationId);

    boolean updateById(TourCoast tourCoast);

    boolean deleteById(Integer id);
}
