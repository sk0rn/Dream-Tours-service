package service.tour.impl;

import pojo.*;
import repository.iface.*;
import repository.impl.*;
import service.tour.iface.ITourExtendSrv;

import java.util.*;
import java.util.stream.Collectors;

import static constants.Consts.*;

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
    public List<TourExtend> getAllByFeature(String feature, Object searchFor) {
        Map<Integer, TourExtend> extendTours;
        Map<Integer, Place> placeMap;
        List<TourPlace> places;
        Map<Integer, Subject> subjectMap;
        List<TourSubject> subjects;

        switch ("" + feature) {
            case SUBJECT:
                extendTours = tourDao.getAllBySubjectId((Integer) searchFor).stream().
                        collect(Collectors.toMap(Tour::getId, TourExtend::new));
                placeMap = placeDao.getAllBySubjectId((Integer) searchFor).stream().
                        collect(Collectors.toMap(Place::getId, p -> p));
                places = tourPlaceDao.getAllBySubjectId((Integer) searchFor);
                subjectMap = subjectDao.getAllBySubjectId((Integer) searchFor).stream().
                        collect(Collectors.toMap(Subject::getId, s -> s));
                subjects = tourSubjectDao.getAllBySubjectId((Integer) searchFor);
                break;
            case PLACE:
                extendTours = tourDao.getAllByPlaceId((Integer) searchFor).stream().
                        collect(Collectors.toMap(Tour::getId, TourExtend::new));
                placeMap = placeDao.getAllByPlaceId((Integer) searchFor).stream().
                        collect(Collectors.toMap(Place::getId, p -> p));
                places = tourPlaceDao.getAllByPlaceId((Integer) searchFor);
                subjectMap = subjectDao.getAllByPlaceId((Integer) searchFor).stream().
                        collect(Collectors.toMap(Subject::getId, s -> s));
                subjects = tourSubjectDao.getAllByPlaceId((Integer) searchFor);
                break;
            case KEYWORD:
                extendTours = tourDao.searchAllByKeyword((String) searchFor).stream().
                        collect(Collectors.toMap(Tour::getId, TourExtend::new));
                placeMap = placeDao.getAll().stream().
                        collect(Collectors.toMap(Place::getId, p -> p));
                places = tourPlaceDao.searchAllByKeyword((String) searchFor);
                subjectMap = subjectDao.getAll().stream().
                        collect(Collectors.toMap(Subject::getId, s -> s));
                subjects = tourSubjectDao.searchAllByKeyword((String) searchFor);
                break;
            default:
                extendTours = tourDao.getAll().stream().
                        collect(Collectors.toMap(Tour::getId, TourExtend::new));
                placeMap = placeDao.getAll().stream().
                        collect(Collectors.toMap(Place::getId, p -> p));
                places = tourPlaceDao.getAll();
                subjectMap = subjectDao.getAll().stream().
                        collect(Collectors.toMap(Subject::getId, s -> s));
                subjects = tourSubjectDao.getAll();
        }

        if (extendTours != null && placeMap != null && places != null
                && subjectMap != null && subjects != null) {
            for (TourPlace tourPlace : places) {
                extendTours.get(tourPlace.getTourId()).
                        getPlaces().
                        add(placeMap.get(tourPlace.getPlaceId()));
            }
            for (TourSubject tourSubject : subjects) {
                extendTours.get(tourSubject.getTourId()).
                        getSubjects().
                        add(subjectMap.get(tourSubject.getSubjectId()));
            }
            return new ArrayList<>(extendTours.values());
        }
        return Collections.emptyList();
    }
}
