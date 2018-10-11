package repository.iface;

import pojo.TourPlace;

import java.util.List;

public interface ITourPlaceDao {

    boolean add(TourPlace tourPlace);

    List<TourPlace> getAllByTourIdPlaceId(Integer tourid, Integer plaseId);
}
