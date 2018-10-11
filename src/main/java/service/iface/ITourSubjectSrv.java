package service.iface;

import pojo.TourSubject;

import java.util.List;

public interface ITourSubjectSrv {

    boolean add(TourSubject tourSubject);

    List<TourSubject> getAllByTourIdSubjectId(Integer tourId, Integer subjectId);
}
