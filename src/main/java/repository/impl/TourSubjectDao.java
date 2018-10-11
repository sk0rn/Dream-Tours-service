package repository.impl;

import pojo.TourSubject;
import repository.background.DaoBackground;
import repository.iface.ITourSubjectDao;

import java.util.List;

public class TourSubjectDao implements ITourSubjectDao {
    private final static DaoBackground<TourSubject> background = new DaoBackground<>(TourSubject::new,
            TourSubject[]::new,
            TourSubject::init);

    @Override
    public boolean add(TourSubject tourSubject) {
        return background.execute("INSERT INTO tour_subject VALUES (?, ?)",
                tourSubject.getTourId(), tourSubject.getSubjectId());
    }

    @Override
    public List<TourSubject> getAllByTourIdSubjectId(Integer tourid, Integer subjectId) {
        return background.fetchRowsAsPojoList("SELECT * FROM tour_subject " +
                "WHERE tour_id=? and subject_id = ?", tourid, subjectId);
    }
}
