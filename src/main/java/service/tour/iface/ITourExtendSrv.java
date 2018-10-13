package service.tour.iface;

import pojo.TourExtend;

import java.util.List;

public interface ITourExtendSrv {

    List<TourExtend> getAllByFeature(String feature, Integer featureId);
}
