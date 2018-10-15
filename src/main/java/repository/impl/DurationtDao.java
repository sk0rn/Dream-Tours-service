package repository.impl;

import pojo.Duration;
import repository.background.DaoBackground;
import repository.iface.IDurationtDao;

import java.util.List;

public class DurationtDao implements IDurationtDao {
    private final static DaoBackground<Duration> background = new DaoBackground<>(Duration::new,
            Duration[]::new,
            Duration::init);

    @Override
    public boolean add(Duration duration) {
        return background.execute("INSERT INTO duration VALUES (Default, ?, ?)",
                duration.getNumberDays(), duration.getName());
    }

    @Override
    public Duration getById(Integer id) {
        return background.fetchOneRowAsPojoObject("select * from duration where id = ?", id);
    }

    @Override
    public List<Duration> getAllByTourId(Integer tourid) {
        return background.fetchRowsAsPojoList("SELECT duration.* \n" +
                "FROM duration as dr\n" +
                "inner join tour_release as tr on tr.duration_id = dr.id and tr.tour_id = ?", tourid);
    }

    @Override
    public List<Duration> getAll() {
        return background.fetchRowsAsPojoList("SELECT * FROM duration");
    }

    @Override
    public boolean updateById(Duration duration) {
        return background.execute("Update duration SET number_days=?," +
                        " name=? where id=?",
                duration.getNumberDays(), duration.getName(),
                duration.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return background.execute("DELETE FROM duration WHERE id = ?",
                id);
    }
}
