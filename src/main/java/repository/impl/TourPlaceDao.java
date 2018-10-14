package repository.impl;

import pojo.TourPlace;
import repository.background.DaoBackground;
import repository.iface.ITourPlaceDao;
import utils.ArrayFill;

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
    public List<TourPlace> getAllByTourIdPlaceId(Integer tourId, Integer placeId) {
        return background.fetchRowsAsPojoList("SELECT * FROM tour_place " +
                "WHERE tour_id=? and place_id = ?", tourId, placeId);
    }

    @Override
    public List<TourPlace> getAll() {
        return background.fetchRowsAsPojoList("SELECT * FROM tour_place");
    }

    @Override
    public List<TourPlace> getAllBySubjectId(Integer subjectId) {
        return background.fetchRowsAsPojoList("select distinct tour_place.*\n" +
                "from tour_place\n" +
                "  join tour t on tour_place.tour_id = t.id\n" +
                "  join tour_subject ts on t.id = ts.tour_id\n" +
                "where ts.subject_id = ?", subjectId);
    }

    /*
    изначально берем все записи в tour_place по искомому place_id,
    затем для id туров найденных по эти местам, получаем place_id других мест,
    которые относятся к эти турам, оставляем только уникальные пересечения
    */
    @Override
    public List<TourPlace> getAllByPlaceId(Integer placeId) {
        return background.fetchRowsAsPojoList("select distinct tp2.*\n" +
                "from tour_place tp\n" +
                "  join tour_place tp2 on tp.tour_id = tp2.tour_id\n" +
                "where tp.place_id = ?", placeId);
    }

    @Override
    public List<TourPlace> searchAllByKeyword(String word) {
        String[] params = ArrayFill.fillSameString(6, "%"+word+"%");
        return background.fetchRowsAsPojoList("with tours1 as (\n" +
                "with places1 as (\n" +
                "    select id from place\n" +
                "    where name ilike ? or descr ilike ?\n" +
                ")\n" +
                "  , subjects1 as (\n" +
                "    select id from subject\n" +
                "    where name ilike ? or descr ilike ?\n" +
                ")\n" +
                "select distinct tour.id\n" +
                "from tour\n" +
                "  left outer join tour_place as tp on tp.tour_id = tour.id\n" +
                "  left outer join places1 on places1.id = tp.place_id\n" +
                "  left outer join tour_subject ts on ts.tour_id = tour.id\n" +
                "  left outer join subjects1 on subjects1.id = ts.subject_id\n" +
                "where tour.name ilike ? or tour.descr ilike ?\n" +
                "      or places1.id is not null\n" +
                "      or subjects1.id is not null)\n" +
                "select tp.*\n" +
                "from tour_place tp\n" +
                "inner join tours1 on tours1.id = tp.tour_id", params);
    }


}
