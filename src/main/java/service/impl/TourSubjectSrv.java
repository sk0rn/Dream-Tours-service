package service.impl;

import pojo.TourSubject;
import repository.iface.ITourSubjectDao;
import repository.impl.TourSubjectDao;
import service.iface.ITourSubjectSrv;

import java.util.List;

public class TourSubjectSrv implements ITourSubjectSrv {
    private ITourSubjectDao tourSubjectDao;

    public TourSubjectSrv() {
        tourSubjectDao = new TourSubjectDao();
    }

    public TourSubjectSrv(ITourSubjectDao tourSubjectDao) {
        this.tourSubjectDao = tourSubjectDao;
    }

    @Override
    public boolean add(TourSubject tourSubject) {
        return tourSubjectDao.add(tourSubject);
    }

    @Override
    public List<TourSubject> getAllByTourIdSubjectId(Integer tourId, Integer subjectId) {
        return tourSubjectDao.getAllByTourIdSubjectId(tourId, subjectId);
    }
}
