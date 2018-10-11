package service.impl;

import pojo.Subject;
import repository.iface.ISubjectDao;
import repository.impl.SubjectDao;
import service.iface.ISubjectSrv;

import java.util.List;

public class SubjectSrv implements ISubjectSrv {
    private ISubjectDao subjectDao;

    public SubjectSrv() {
        this.subjectDao = new SubjectDao();
    }

    public SubjectSrv(ISubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    @Override
    public boolean add(Subject subject) {
        return subjectDao.add(subject);
    }

    @Override
    public Subject getById(Integer id) {
        return subjectDao.getById(id);
    }

    @Override
    public List<Subject> getAll() {
        return subjectDao.getAll();
    }

    @Override
    public boolean updateById(Subject subject) {
        return subjectDao.updateById(subject);
    }

    @Override
    public boolean deleteById(Integer id) {
        return subjectDao.deleteById(id);
    }
}
