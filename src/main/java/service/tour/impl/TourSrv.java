package service.tour.impl;

import pojo.Tour;
import repository.iface.ITourDao;
import repository.impl.TourDao;
import service.tour.iface.ITourSrv;

import java.util.List;

public class TourSrv implements ITourSrv {
    private ITourDao tourDao;

    public TourSrv() {
        this.tourDao = new TourDao();
    }

    @Override
    public boolean add(Tour tour) {
        return tourDao.add(tour);
    }

    @Override
    public Tour getById(Integer id) {
        return tourDao.getById(id);
    }

    @Override
    public List<Tour> getAll() {
        return tourDao.getAll();
    }

    @Override
    public List<Tour> getBySubjectId(Integer subjectId) {
        return tourDao.getBySubjectId(subjectId);
    }

    @Override
    public List<Tour> getByClientId(Integer clientId) {
        return tourDao.getByClientId(clientId);
    }

    @Override
    public List<Tour> getByOrderId(Integer orderId) {
        return tourDao.getByOrderId(orderId);
    }

    @Override
    public boolean update(Tour tour) {
        return tourDao.update(tour);
    }

    @Override
    public boolean deleteById(Integer id) {
        return tourDao.deleteById(id);
    }
}
