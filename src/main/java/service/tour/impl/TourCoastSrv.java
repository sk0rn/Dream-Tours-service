package service.tour.impl;

import pojo.TourCoast;
import repository.iface.ITourCoastDao;
import repository.impl.TourCoastDao;
import service.tour.iface.ITourCoastSrv;

import java.util.List;

public class TourCoastSrv implements ITourCoastSrv {
    private ITourCoastDao tourCoastDao;

    public TourCoastSrv() {
        this.tourCoastDao = new TourCoastDao();
    }

    public TourCoastSrv(ITourCoastDao tourCoastDao) {
        this.tourCoastDao = tourCoastDao;
    }

    @Override
    public boolean add(TourCoast tourCoast) {
        return tourCoastDao.add(tourCoast);
    }

    @Override
    public List<TourCoast> getAllByTourDuration(Integer tourDurationId) {
        return tourCoastDao.getAllByTourDuration(tourDurationId);
    }

    @Override
    public boolean updateById(TourCoast tourCoast) {
        return tourCoastDao.updateById(tourCoast);
    }

    @Override
    public boolean deleteById(Integer id) {
        return tourCoastDao.deleteById(id);
    }
}
