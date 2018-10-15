package repository.impl;

import pojo.TourDuration;
import repository.background.DaoBackground;
import repository.iface.ITourDurationtDao;

import java.util.List;

public class TourDurationtDao implements ITourDurationtDao {
    private final static DaoBackground<TourDuration> background = new DaoBackground<>(TourDuration::new,
            TourDuration[]::new,
            TourDuration::init);

    @Override
    public boolean add(TourDuration tourDuration) {
        return background.execute("INSERT INTO duration VALUES (Default, ?, ?)",
                tourDuration.getNumberDays(), tourDuration.getDesc());
    }

    @Override
    public TourDuration getById(Integer id) {
        return background.fetchOneRowAsPojoObject("select * from duration where id = ?", id);
    }

    @Override
    public List<TourDuration> getAllByTourId(Integer tourid) {
        return background.fetchRowsAsPojoList("SELECT * FROM duration " +
                "WHERE tour_id=?", tourid);
    }

    @Override
    public List<TourDuration> getAll() {
        return background.fetchRowsAsPojoList("SELECT * FROM duration");
    }

    @Override
    public boolean updateById(TourDuration tourDuration) {
        return background.execute("Update duration SET number_days=?," +
                        " desc=? where id=?",
                tourDuration.getNumberDays(), tourDuration.getDesc(),
                tourDuration.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return background.execute("DELETE FROM duration WHERE id = ?",
                id);
    }
}
