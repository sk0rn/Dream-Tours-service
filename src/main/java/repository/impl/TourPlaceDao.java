package repository.impl;

import pojo.TourPlace;
import repository.background.DaoBackground;
import repository.iface.ITourPlaceDao;

import java.util.List;

public class TourPlaceDao implements ITourPlaceDao {
    private final static DaoBackground<TourPlace> background = new DaoBackground<>(TourPlace::new,
            TourPlace[]::new,
            TourPlace::init);

    @Override
    public boolean add(TourPlace tourPlace) {
        return background.execute("INSERT INTO tour_place VALUES (?, ?)",
                tourPlace.getTourId(), tourPlace.getPlaceId());
    }

    @Override
    public List<TourPlace> getAllByTourIdPlaceId(Integer tourid, Integer plaseId) {
        return background.fetchRowsAsPojoList("SELECT * FROM tour_place " +
                "WHERE tour_id=? and place_id = ?", tourid, plaseId);
    }
}
