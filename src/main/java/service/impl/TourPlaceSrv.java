package service.impl;

import pojo.TourPlace;
import repository.iface.ITourPlaceDao;
import repository.impl.TourPlaceDao;
import service.iface.ITourPlaceSrv;

import java.util.List;

public class TourPlaceSrv implements ITourPlaceSrv {
    private ITourPlaceDao tourPlaceDao;

    public TourPlaceSrv() {
        this.tourPlaceDao = new TourPlaceDao();
    }

    public TourPlaceSrv(ITourPlaceDao tourPlaceDao) {
        this.tourPlaceDao = tourPlaceDao;
    }

    @Override
    public boolean add(TourPlace tourPlace) {
        return tourPlaceDao.add(tourPlace);
    }

    @Override
    public List<TourPlace> getAllByTourIdPlaceId(Integer tourId,
                                                 Integer placeId) {
        return getAllByTourIdPlaceId(tourId, placeId);
    }
}
