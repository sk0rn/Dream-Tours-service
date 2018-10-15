package repository.impl;

import pojo.TourSubject;
import repository.background.DaoBackground;
import repository.iface.ITourSubjectDao;
import utils.ArrayFill;

import java.util.List;

public class TourSubjectDao implements ITourSubjectDao {
    private final static DaoBackground<TourSubject> background = new DaoBackground<>(TourSubject::new,
            TourSubject[]::new,
            TourSubject::init);

    @Override
    public boolean add(TourSubject tourSubject) {
        return background.execute("INSERT INTO tour_subject VALUES (?, ?)",
                tourSubject.getTourId(), tourSubject.getSubjectId());
    }

    @Override
    public List<TourSubject> getAllByTourIdSubjectId(Integer tourId, Integer subjectId) {
        return background.fetchRowsAsPojoList("SELECT * FROM tour_subject " +
                "WHERE tour_id=? and subject_id = ?", tourId, subjectId);
    }

    @Override
    public List<TourSubject> getAll() {
        return background.fetchRowsAsPojoList("SELECT * FROM tour_subject");
    }

    @Override
    public List<TourSubject> getAllBySubjectId(Integer subjectId) {
        return background.fetchRowsAsPojoList("select distinct ts2.*\n" +
                "from tour_subject ts\n" +
                "  join tour_subject ts2 on ts.tour_id = ts2.tour_id\n" +
                "where ts.subject_id = ?", subjectId);
    }

    @Override
    public List<TourSubject> getAllByPlaceId(Integer placeId) {
        return background.fetchRowsAsPojoList("select distinct tour_subject.*\n" +
                "from tour_subject\n" +
                "  join tour t on tour_subject.tour_id = t.id\n" +
                "  join tour_place tp on t.id = tp.tour_id\n" +
                "where tp.place_id = ?", placeId);
    }

    /**
     * Метод применяет SQL запрос, использующий для поиска ключевое слово.
     * В данном случае ключевое слово ищется в нескольких таблицах,
     * поэтому в метод fetchRowsAsPojoList() необходимо передать столько
     * аргументов, сколько раз в запросе используется параметров поиска.
     * Все аргументы должны иметь одно значение - значение искомого ключевого слова
     * */
    @Override
    public List<TourSubject> searchAllByKeyword(String word) {
        String[] params = ArrayFill.fillSameString(6, "%"+word+"%");
        return background.fetchRowsAsPojoList("with tours1 as (\n" +
                "  with places1 as (\n" +
                "      select id from place\n" +
                "      where name ilike ? or descr ilike ?\n" +
                "  )\n" +
                "    , subjects1 as (\n" +
                "      select id from subject\n" +
                "      where name ilike ? or descr ilike ?\n" +
                "  )\n" +
                "  select distinct tour.id\n" +
                "  from tour\n" +
                "    left outer join tour_place as tp on tp.tour_id = tour.id\n" +
                "    left outer join places1 on places1.id = tp.place_id\n" +
                "    left outer join tour_subject ts on ts.tour_id = tour.id\n" +
                "    left outer join subjects1 on subjects1.id = ts.subject_id\n" +
                "  where tour.name ilike ? or tour.descr ilike ?\n" +
                "        or places1.id is not null\n" +
                "        or subjects1.id is not null)\n" +
                "select ts.*\n" +
                "from tour_subject ts\n" +
                "  inner join tours1 on tours1.id = ts.tour_id", params);
    }
}
