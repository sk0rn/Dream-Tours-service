package service.tour.impl;

import pojo.TourRelease;
import repository.iface.ITourReleaseDao;
import repository.impl.TourReleaseDao;
import service.tour.iface.ITourReleaseSrv;

import java.util.List;

public class TourReleaseSrv implements ITourReleaseSrv {
    private ITourReleaseDao tourReleaseDao;


    public TourReleaseSrv() {
        this.tourReleaseDao = new TourReleaseDao();
    }

    @Override

    public boolean add(TourRelease tourRelease) {
        return tourReleaseDao.add(tourRelease);
    }

    @Override
    public TourRelease getById(Integer id) {
        return tourReleaseDao.getById(id);
    }

    @Override
    public List<TourRelease> getAllByTourId(Integer tourId) {
        return tourReleaseDao.getAllByTourId(tourId);
    }

    @Override
    public boolean updateById(TourRelease tourRelease) {
        return tourReleaseDao.updateById(tourRelease);
    }

    @Override
    public boolean deleteById(Integer id) {
        return tourReleaseDao.deleteById(id);
    }
}
