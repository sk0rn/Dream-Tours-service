package repository.impl;

import pojo.Subject;
import repository.background.DaoBackground;
import repository.iface.ISubjectDao;

import java.util.List;

public class SubjectDao implements ISubjectDao {
    private final static DaoBackground<Subject> background = new DaoBackground<>(Subject::new,
            Subject[]::new,
            Subject::init);

    @Override
    public boolean add(Subject subject) {
        return background.execute("INSERT INTO subject VALUES (Default, ?, ?)",
                subject.getName(), subject.getDesc());
    }

    @Override
    public Subject getById(Integer id) {
        return background.fetchOneRowAsPojoObject("select * from subject where id = ?", id);
    }

    @Override
    public List<Subject> getAll() {
        return background.fetchRowsAsPojoList("SELECT * FROM subject ");
    }

    @Override
    public List<Subject> getAllBySubjectId(Integer subjectId) {
        return background.fetchRowsAsPojoList("select distinct s.*\n" +
                "from tour_subject ts\n" +
                "  join tour_subject ts2 on ts.tour_id = ts2.tour_id\n" +
                "  join subject s on ts2.subject_id = s.id\n" +
                "where ts.subject_id = ?", subjectId);
    }

    @Override
    public List<Subject> getAllByPlaceId(Integer placeId) {
        return background.fetchRowsAsPojoList("select distinct subject.*\n" +
                "from subject\n" +
                "  join tour_subject ts on subject.id = ts.subject_id\n" +
                "  join tour_place tp on tp.tour_id = ts.tour_id\n" +
                "where tp.place_id = ?", placeId);
    }

    @Override
    public boolean updateById(Subject subject) {
        return background.execute("Update subject SET name=?, descr=? where id=?",
                subject.getName(), subject.getDesc(), subject.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return background.execute("DELETE FROM subject WHERE id = ?",
                id);
    }
}
