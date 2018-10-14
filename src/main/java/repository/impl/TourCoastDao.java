package repository.impl;

import pojo.TourCoast;
import repository.background.DaoBackground;
import repository.iface.ITourCoastDao;

import java.util.List;

public class TourCoastDao implements ITourCoastDao {
    private final static DaoBackground<TourCoast> background = new DaoBackground<>(TourCoast::new,
            TourCoast[]::new,
            TourCoast::init);

    @Override
    public boolean add(TourCoast tourCoast) {
        return background.execute("INSERT INTO tour_coast VALUES (Default, ?, ?, ?, ?, ?)",
                tourCoast.getTourDurationId(), tourCoast.getKind(), tourCoast.getCoast(),
                tourCoast.getClippingAge(), tourCoast.getParticipant());
    }

    @Override
    public List<TourCoast> getAllByTourDuration(Integer tourDurationId) {
        return background.fetchRowsAsPojoList("SELECT * FROM tour_coast " +
                "WHERE duration_id=?", tourDurationId);
    }

    @Override
    public boolean updateById(TourCoast tourCoast) {
        return background.execute("Update tour_coast SET duration_id=?, kind=?," +
                        " coast=?, clippino_age=?, isParticipant=? where id=?",
                tourCoast.getTourDurationId(), tourCoast.getKind(), tourCoast.getCoast(),
                tourCoast.getClippingAge(), tourCoast.getParticipant(), tourCoast.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return background.execute("DELETE FROM tour_coast WHERE id = ?",
                id);
    }
}
