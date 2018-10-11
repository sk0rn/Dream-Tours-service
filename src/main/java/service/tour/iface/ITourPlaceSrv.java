package service.tour.iface;

import pojo.TourPlace;

import java.util.List;

public interface ITourPlaceSrv {

    boolean add(TourPlace tourPlace);

    List<TourPlace> getAllByTourIdPlaceId(Integer tourId, Integer placeId);
}
