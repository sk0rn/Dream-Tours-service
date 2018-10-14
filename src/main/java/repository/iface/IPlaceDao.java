package repository.iface;

import pojo.Place;

import java.util.List;

public interface IPlaceDao {

    boolean add(Place place);

    Place getById(Integer id);

    List<Place> getAll();

    List<Place> getAllBySubjectId(Integer subjectId);

    List<Place> getAllByPlaceId(Integer placeId);

    boolean updateById(Place place);

    boolean deleteById(Integer id);
}
