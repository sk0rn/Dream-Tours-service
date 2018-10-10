package repository.iface;

import pojo.Place;

import java.util.List;

public interface IPlaceDao {

    boolean add(Place place);

    Place getById(Integer id);

    List<Place> getAll();

    boolean updateById(Place place);

    boolean deleteById(Integer id);
}
