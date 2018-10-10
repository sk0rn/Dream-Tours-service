package repository.iface;

import pojo.Participant;

import java.util.List;

public interface IParticipantDao {

    boolean add(Participant participant);

    Participant getById(Integer id);

    List<Participant> getAllByOrderId(Integer orderId);

    boolean updateById(Participant participant);

    boolean deleteById(Integer id);
}
