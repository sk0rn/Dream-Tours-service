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
    public List<Place> getAllBySubjectId(Integer subjectId) {
        return background.fetchRowsAsPojoList("select distinct place.*\n" +
                "from place\n" +
                "  join tour_place tp on place.id = tp.place_id\n" +
                "  join tour_subject ts on ts.tour_id = tp.tour_id\n" +
                "where ts.subject_id = ?", subjectId);
    }

    /*
    изначально берем все записи в tour_place по искомому place_id,
    затем для туров найденных по эти местам, получаем другие места,
    которые относятся к эти турам, оставляем только уникальные места
    */
    @Override
    public List<Place> getAllByPlaceId(Integer placeId) {
        return background.fetchRowsAsPojoList("select distinct p.*\n" +
                "from tour_place tp\n" +
                "  join tour_place tp2 on tp.tour_id = tp2.tour_id\n" +
                "  join place p on tp2.place_id = p.id\n" +
                "where tp.place_id = ?", placeId);
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
