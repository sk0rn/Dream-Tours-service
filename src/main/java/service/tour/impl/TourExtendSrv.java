package service.tour.impl;

import pojo.*;
import repository.iface.*;
import repository.impl.*;
import service.tour.iface.ITourExtendSrv;

import java.util.Map;
import java.util.stream.Collectors;

public class TourExtendSrv implements ITourExtendSrv {
    private ITourDao tourDao;
    private IPlaceDao placeDao;
    private ITourPlaceDao tourPlaceDao;
    private ISubjectDao subjectDao;
    private ITourSubjectDao tourSubjectDao;

    public TourExtendSrv() {
        this.tourDao = new TourDao();
        this.placeDao = new PlaceDao();
        this.tourPlaceDao = new TourPlaceDao();
        this.subjectDao = new SubjectDao();
        this.tourSubjectDao = new TourSubjectDao();

    }

    public TourExtendSrv(ITourDao tourDao, IPlaceDao placeDao,
                         ITourPlaceDao tourPlaceDao, ISubjectDao subjectDao,
                         ITourSubjectDao tourSubjectDao) {
        this.tourDao = tourDao;
        this.placeDao = placeDao;
        this.tourPlaceDao = tourPlaceDao;
        this.subjectDao = subjectDao;
        this.tourSubjectDao = tourSubjectDao;
    }

    @Override
    public Map<Integer, TourExtend> getAll() {
        Map<Integer, TourExtend> extendTours =
                tourDao.getAll().stream().collect(Collectors.toMap(Tour::getId, TourExtend::new));


        Map<Integer, Place> placeMap =
                placeDao.getAll().stream().collect(Collectors.toMap(Place::getId, p -> p));
        for (TourPlace tourPlace : tourPlaceDao.getAll()) {
            extendTours.get(tourPlace.getTourId()).
                            getPlaces().
                            add(placeMap.get(tourPlace.getPlaceId()));
        }

        Map<Integer, Subject> subjectMap =
                subjectDao.getAll().stream().collect(Collectors.toMap(Subject::getId, s -> s));
        for (TourSubject tourSubject : tourSubjectDao.getAll()) {
            extendTours.get(tourSubject.getTourId()).
                    getSubjects().
                    add(subjectMap.get(tourSubject.getSubjectId()));
        }

        return extendTours;
    }
}
