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
    public boolean updateById(Subject subject) {
        return background.execute("Update subject SET name=?, desc=? where id=?",
                subject.getName(), subject.getDesc(), subject.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return background.execute("DELETE FROM subject WHERE id = ?",
                id);
    }
}
