package service.iface;

import pojo.TourCoast;

import java.util.List;

public interface ITourCoastSrv {

    boolean add(TourCoast tourCoast);

    List<TourCoast> getAllByTourDuration(Integer tourDurationId);

    boolean updateById(TourCoast tourCoast);

    boolean deleteById(Integer id);
}
