package repository.iface;

import pojo.TourSubject;

import java.util.List;

public interface ITourSubjectDao {

    boolean add(TourSubject tourSubject);

    List<TourSubject> getAllByTourIdSubjectId(Integer tourid, Integer subjectId);

    List<TourSubject> getAll();
}
