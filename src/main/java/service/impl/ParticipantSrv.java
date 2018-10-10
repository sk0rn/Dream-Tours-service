package service.impl;

import pojo.Participant;
import repository.iface.IParticipantDao;
import repository.impl.ParticipantDao;
import service.iface.IParticipantSrv;

import java.util.List;

public class ParticipantSrv implements IParticipantSrv {
    private IParticipantDao participantDao;

    public ParticipantSrv() {
        this.participantDao = new ParticipantDao();
    }

    public ParticipantSrv(IParticipantDao participantDao) {
        this.participantDao = participantDao;
    }

    @Override
    public boolean add(Participant participant) {
        return participantDao.add(participant);
    }

    @Override
    public Participant getById(Integer id) {
        return participantDao.getById(id);
    }

    @Override
    public List<Participant> getAllByOrderId(Integer orderId) {
        return participantDao.getAllByOrderId(orderId);
    }

    @Override
    public boolean updateById(Participant participant) {
        return participantDao.updateById(participant);
    }

    @Override
    public boolean deleteById(Integer id) {
        return participantDao.deleteById(id);
    }
}
