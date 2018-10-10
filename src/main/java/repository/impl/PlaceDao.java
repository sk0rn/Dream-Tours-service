package repository.impl;

import pojo.Place;
import repository.background.DaoBackground;
import repository.iface.IPlaceDao;

import java.util.List;

public class PlaceDao implements IPlaceDao {
    private final static DaoBackground<Place> background = new DaoBackground<>(Place::new,
            Place[]::new,
            Place::init);

    @Override
    public boolean add(Place place) {
        return background.execute("INSERT INTO place VALUES (Default, ?, ?)",
                place.getName(), place.getDesc());
    }

    @Override
    public Place getById(Integer id) {
        return background.fetchOneRowAsPojoObject("select * from place where id = ?", id);
    }

    @Override
    public List<Place> getAll() {
        return background.fetchRowsAsPojoList("SELECT * FROM place ");
    }

    @Override
    public boolean updateById(Place place) {
        return background.execute("Update place SET name=?, desc=? where id=?",
                place.getName(), place.getDesc(), place.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return background.execute("DELETE FROM place WHERE id = ?",
                id);
    }
}
