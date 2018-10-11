package service.tour.iface;

import pojo.Place;

import java.util.List;

public interface IPlaceSrv {

    boolean add(Place place);

    Place getById(Integer id);

    List<Place> getAll();

    boolean updateById(Place place);

    boolean deleteById(Integer id);
}
