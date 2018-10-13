package repository.impl;

import pojo.TourRelease;
import repository.background.DaoBackground;
import repository.iface.ITourReleaseDao;

import java.util.List;

public class TourReleaseDao implements ITourReleaseDao {
    private final static DaoBackground<TourRelease> background = new DaoBackground<>(TourRelease::new,
            TourRelease[]::new,
            TourRelease::init);

    @Override
    public boolean add(TourRelease tourRelease) {
        return background.execute("INSERT INTO tour_release VALUES (Default, ?, ?, ?, ?)",
                tourRelease.getTourId(), tourRelease.getTourDurationId(), tourRelease.getBeginTime(), tourRelease.getCapacity());
    }

    @Override
    public TourRelease getById(Integer id) {
        return background.fetchOneRowAsPojoObject("select * from tour_release where id = ?", id);
    }

    @Override
    public List<TourRelease> getAllByTourId(Integer tourid) {
        return background.fetchRowsAsPojoList("SELECT * FROM tour_release" +
                " inner join tour_duration on tour_release.tour_duration_id = tour_duration.id" +
                " WHERE tour_duration.tour_id=?", tourid);
    }

    @Override
    public boolean updateById(TourRelease tourRelease) {
        return background.execute("Update tour_release SET tour_id=? tour_duration_id=?, begin_time=?," +
                        " capacity=? where id=?",
                tourRelease.getTourId(), tourRelease.getTourDurationId(), tourRelease.getBeginTime(), tourRelease.getCapacity(),
                tourRelease.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return background.execute("DELETE FROM tour_release WHERE id = ?",
                id);
    }
}
