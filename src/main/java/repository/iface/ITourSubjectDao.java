package repository.iface;

import pojo.TourSubject;

import java.util.List;

public interface ITourSubjectDao {

    boolean add(TourSubject tourSubject);

    List<TourSubject> getAllByTourIdSubjectId(Integer tourId, Integer subjectId);

    List<TourSubject> getAll();

    List<TourSubject> getAllBySubjectId(Integer subjectId);

    List<TourSubject> getAllByPlaceId(Integer placeId);
}
