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
    public List<TourSubject> getAllByTourIdSubjectId(Integer tourId, Integer subjectId) {
        return background.fetchRowsAsPojoList("SELECT * FROM tour_subject " +
                "WHERE tour_id=? and subject_id = ?", tourId, subjectId);
    }

    @Override
    public List<TourSubject> getAll() {
        return background.fetchRowsAsPojoList("SELECT * FROM tour_subject");
    }

    @Override
    public List<TourSubject> getAllBySubjectId(Integer subjectId) {
        return background.fetchRowsAsPojoList("select distinct ts2.*\n" +
                "from tour_subject ts\n" +
                "  join tour_subject ts2 on ts.tour_id = ts2.tour_id\n" +
                "where ts.subject_id = ?", subjectId);
    }

    @Override
    public List<TourSubject> getAllByPlaceId(Integer placeId) {
        return background.fetchRowsAsPojoList("select distinct tour_subject.*\n" +
                "from tour_subject\n" +
                "  join tour t on tour_subject.tour_id = t.id\n" +
                "  join tour_place tp on t.id = tp.tour_id\n" +
                "where tp.place_id = ?", placeId);
    }
}
