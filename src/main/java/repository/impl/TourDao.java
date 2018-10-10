package repository.impl;

import pojo.Tour;
import repository.background.DaoBackground;
import repository.iface.ITourDao;

import java.util.List;

public class TourDao implements ITourDao {
    private final static DaoBackground<Tour> background = new DaoBackground<>(Tour::new,
            Tour[]::new,
            Tour::init);

    @Override
    public boolean add(Tour tour) {
        return background.execute("INSERT INTO tour VALUES (Default, ?, ?, ?)",
                tour.getAlbumGuid(), tour.getYoutubeUrl(), tour.getDesc());
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
    public List<Tour> getBySubjectId(Integer subjecId) {
        return background.fetchRowsAsPojoList("SELECT * FROM tour" +
                " inner join tour_subject on tour.id = tour_subject.tour_id" +
                " WHERE tour_subject.subject_id=?", subjecId);
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
        return background.execute("Update tour SET album_guid =?, youtube_url=?, desc=? where id=?",
                tour.getAlbumGuid(), tour.getYoutubeUrl(), tour.getDesc(), tour.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return background.execute("DELETE FROM tour WHERE id = ?",
                id);
    }
}
