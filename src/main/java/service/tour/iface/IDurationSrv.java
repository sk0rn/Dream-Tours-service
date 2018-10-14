package service.tour.iface;

import pojo.Duration;

import java.util.List;

public interface IDurationSrv {

    boolean add(Duration duration);

    Duration getById(Integer id);

    List<Duration> getAllByTourId(Integer tourId);

    boolean updateById(Duration duration);

    boolean deleteById(Integer id);

    List<Duration> getAll();
}
