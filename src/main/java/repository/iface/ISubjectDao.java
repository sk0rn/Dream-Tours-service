package repository.iface;

import pojo.Subject;

import java.util.List;

public interface ISubjectDao {

    boolean add(Subject subject);

    Subject getById(Integer id);

    List<Subject> getAll();

    boolean updateById(Subject subject);

    boolean deleteById(Integer id);
}
