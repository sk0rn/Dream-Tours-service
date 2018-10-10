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
        return background.execute("INSERT INTO tour_duration VALUES (Default, ?, ?, ?)",
                tourDuration.getTourId(), tourDuration.getNumberDays(), tourDuration.getDesc());
    }

    @Override
    public TourDuration getById(Integer id) {
        return background.fetchOneRowAsPojoObject("select * from tour_duration where id = ?", id);
    }

    @Override
    public List<TourDuration> getAllByTourId(Integer tourid) {
        return background.fetchRowsAsPojoList("SELECT * FROM tour_duration " +
                "WHERE tour_id=?", tourid);
    }

    @Override
    public boolean updateById(TourDuration tourDuration) {
        return background.execute("Update tour_duration SET tour_id=?, number_days=?," +
                        " desc=? where id=?",
                tourDuration.getTourId(), tourDuration.getNumberDays(), tourDuration.getDesc(),
                tourDuration.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return background.execute("DELETE FROM tour_duration WHERE id = ?",
                id);
    }
}
