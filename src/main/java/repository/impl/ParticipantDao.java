package repository.impl;

import pojo.Participant;
import repository.background.DaoBackground;
import repository.iface.IParticipantDao;

import java.util.List;

public class ParticipantDao implements IParticipantDao {
    private static final DaoBackground<Participant> background = new DaoBackground<>(Participant::new,
            Participant[]::new,
            Participant::init);

    @Override
    public boolean add(Participant participant) {
        return background.execute("INSERT INTO participant VALUES (Default, ?, ?, ?)",
                participant.getOrderId(), participant.getClippingAge(), participant.getQuantity());
    }

    @Override
    public Participant getById(Integer id) {
        return background.fetchOneRowAsPojoObject("select * from participant where id = ?", id);
    }

    @Override
    public List<Participant> getAllByOrderId(Integer orderId) {
        return background.fetchRowsAsPojoList("SELECT * FROM participant " +
                "WHERE order_id=?", orderId);
    }

    @Override
    public boolean updateById(Participant participant) {
        return background.execute("Update participant SET order_id=?, clipping_age=?, quantity=?\n" +
                        "  where id=?", participant.getOrderId(), participant.getClippingAge(),
                participant.getQuantity(), participant.getId());
    }

    @Override
    public boolean deleteById(Integer id) {
        return background.execute("DELETE FROM participant WHERE id = ?",
                id);
    }
}
