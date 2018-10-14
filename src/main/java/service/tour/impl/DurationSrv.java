package service.tour.impl;

import pojo.Duration;
import repository.iface.IDurationtDao;
import repository.impl.DurationtDao;
import service.tour.iface.IDurationSrv;

import java.util.List;

public class DurationSrv implements IDurationSrv {
    private IDurationtDao tourDurationtDao;

    public DurationSrv() {
        this.tourDurationtDao = new DurationtDao();
    }

    public DurationSrv(IDurationtDao tourDurationDao) {
        this.tourDurationtDao = tourDurationDao;
    }

    @Override
    public boolean add(Duration duration) {
        return tourDurationtDao.add(duration);
    }

    @Override
    public Duration getById(Integer id) {
        return tourDurationtDao.getById(id);
    }

    @Override
    public List<Duration> getAllByTourId(Integer tourId) {
        return tourDurationtDao.getAllByTourId(tourId);
    }

    @Override
    public boolean updateById(Duration duration) {
        return tourDurationtDao.updateById(duration);
    }

    @Override
    public boolean deleteById(Integer id) {
        return tourDurationtDao.deleteById(id);
    }

    @Override
    public List<Duration> getAll() {
        return tourDurationtDao.getAll();
    }
}
