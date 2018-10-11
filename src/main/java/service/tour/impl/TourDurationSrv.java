package service.tour.impl;

import pojo.TourDuration;
import repository.iface.ITourDurationtDao;
import repository.impl.TourDurationtDao;
import service.tour.iface.ITourDurationSrv;

import java.util.List;

public class TourDurationSrv implements ITourDurationSrv {
    private ITourDurationtDao tourDurationtDao;

    public TourDurationSrv() {
        this.tourDurationtDao = new TourDurationtDao();
    }

    public TourDurationSrv(ITourDurationtDao tourDurationDao) {
        this.tourDurationtDao = tourDurationDao;
    }

    @Override
    public boolean add(TourDuration tourDuration) {
        return tourDurationtDao.add(tourDuration);
    }

    @Override
    public TourDuration getById(Integer id) {
        return tourDurationtDao.getById(id);
    }

    @Override
    public List<TourDuration> getAllByTourId(Integer tourId) {
        return tourDurationtDao.getAllByTourId(tourId);
    }

    @Override
    public boolean updateById(TourDuration tourDuration) {
        return tourDurationtDao.updateById(tourDuration);
    }

    @Override
    public boolean deleteById(Integer id) {
        return tourDurationtDao.deleteById(id);
    }
}
