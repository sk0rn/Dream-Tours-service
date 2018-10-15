package repository.iface;

import pojo.Duration;

import java.util.List;

public interface IDurationtDao {

    boolean add(Duration duration);

    Duration getById(Integer id);

    List<Duration> getAllByTourId(Integer tourd);

    boolean updateById(Duration duration);

    boolean deleteById(Integer id);

    public List<Duration> getAll();
}
