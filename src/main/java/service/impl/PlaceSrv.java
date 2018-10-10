package service.impl;

import pojo.Place;
import repository.iface.IPlaceDao;
import repository.impl.PlaceDao;
import service.iface.IPlaceSrv;

import java.util.List;

public class PlaceSrv implements IPlaceSrv {
    private IPlaceDao placeDao;

    public PlaceSrv() {
        placeDao = new PlaceDao();
    }


    public PlaceSrv(IPlaceDao placeDao) {
        this.placeDao = placeDao;
    }

    @Override
    public boolean add(Place place) {
        return placeDao.add(place);
    }

    @Override
    public Place getById(Integer id) {
        return placeDao.getById(id);
    }

    @Override
    public List<Place> getAll() {
        return placeDao.getAll();
    }

    @Override
    public boolean updateById(Place place) {
        return placeDao.updateById(place);
    }

    @Override
    public boolean deleteById(Integer id) {
        return placeDao.deleteById(id);
    }
}
