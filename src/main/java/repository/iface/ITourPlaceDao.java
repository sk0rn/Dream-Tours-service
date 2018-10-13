package repository.iface;

import pojo.TourPlace;

import java.util.List;

public interface ITourPlaceDao {

    boolean add(TourPlace tourPlace);

    List<TourPlace> getAllByTourIdPlaceId(Integer tourid, Integer plaseId);

    List<TourPlace> getAll();

    List<TourPlace> getAllBySubjectId(Integer subjectId);

    List<TourPlace> getAllByPlaceId(Integer placeId);
}
