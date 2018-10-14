package repository.impl;

import pojo.Tour;
import repository.background.DaoBackground;
import repository.iface.ITourDao;
import utils.ArrayFill;

import java.util.List;

public class TourDao implements ITourDao {
    private final static DaoBackground<Tour> background = new DaoBackground<>(Tour::new,
            Tour[]::new,
            Tour::init);

    @Override
    public boolean add(Tour tour) {
        return background.execute("INSERT INTO tour VALUES (Default, ?, ?, ?, ?)",
                tour.getName(), tour.getAlbumGuid(), tour.getYoutubeUrl(), tour.getDesc());
    }

    @Override
    public Tour getById(Integer id) {
        return background.fetchOneRowAsPojoObject("select * from tour where id = ?", id);
    }

    @Override
    public List<Tour> getAll() {
        return background.fetchRowsAsPojoList("SELECT * FROM tour");
    }

    @Override
    public List<Tour> getAllBySubjectId(Integer subjectId) {
        return background.fetchRowsAsPojoList("SELECT tour.* FROM tour" +
                " inner join tour_subject on tour.id = tour_subject.tour_id" +
                " WHERE tour_subject.subject_id=?", subjectId);
    }

    @Override
    public List<Tour> getAllByPlaceId(Integer placeId) {
        return background.fetchRowsAsPojoList("SELECT tour.* FROM tour\n" +
                "  inner join tour_place tp on tour.id = tp.tour_id\n" +
                "  WHERE tp.place_id = ?", placeId);
    }

    /**
     * Метод применяет SQL запрос, использующий для поиска ключевое слово.
     * В данном случае ключевое слово ищется в нескольких таблицах,
     * поэтому в метод fetchRowsAsPojoList() необходимо передать столько
     * аргументов, сколько раз в запросе используется параметров поиска.
     * Все аргументы должны иметь одно значение - значение искомого ключевого слова
    * */
    @Override
    public List<Tour> searchAllByKeyword(String word) {
        String[] params = ArrayFill.fillSameString(6, "%"+word+"%");
        return background.fetchRowsAsPojoList("with places1 as (\n" +
                "    select id\n" +
                "    from place\n" +
                "    where name ilike ? or descr ilike ?\n" +
                ")\n" +
                "  , subjects1 as (\n" +
                "    select id\n" +
                "    from subject\n" +
                "    where name ilike ? or descr ilike ?\n" +
                ")\n" +
                "select distinct tour.*\n" +
                "from tour\n" +
                "  left outer join tour_place as tp on tp.tour_id = tour.id\n" +
                "  left outer join places1 on places1.id = tp.place_id\n" +
                "  left outer join tour_subject ts on ts.tour_id = tour.id\n" +
                "  left outer join subjects1 on subjects1.id = ts.subject_id\n" +
                "where tour.name ilike ? or tour.descr ilike ?\n" +
                "      or places1.id is not null" +
                "      or subjects1.id is not null;", params);
    }

    @Override
    public List<Tour> getByClientId(Integer clientId) {
        return background.fetchRowsAsPojoList("SELECT * FROM tour" +
                " inner join wishlist on tour.id = wishlist.tour_id" +
                " WHERE wishlist.client_id=?", clientId);
    }

    @Override
    public List<Tour> getByOrderId(Integer orderId) {
        return background.fetchRowsAsPojoList("SELECT * FROM (( inner join tour_duration on " +
                "tour.id = tour_duration.tour_id) inner join tour_release on " +
                "tour_duration.id = tour_release.tour_duration_id) inner join orders on " +
                "tour_release.id = orders.tour_release_id WHERE orders.id=?", orderId);
    }

    @Override
    public boolean update(Tour tour) {
        return background.execute("Update tour SET name=? album_guid =?, youtube_url=?, desc=? where id=?",
                tour.getName(), tour.getAlbumGuid(), tour.getYoutubeUrl(), tour.getDesc(), tour.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return background.execute("DELETE FROM tour WHERE id = ?",
                id);
    }
}
