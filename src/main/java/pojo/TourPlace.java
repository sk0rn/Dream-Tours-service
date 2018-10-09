package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class TourPlace implements Initiable {
    private Integer tourId;
    private Integer placeId;

    public TourPlace() {
    }

    public TourPlace(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 2) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.tourId = (Integer) fields[0];
        this.placeId = (Integer) fields[1];
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Integer placeId) {
        this.placeId = placeId;
    }

    @Override
    public String toString() {
        return "TourPlace{" +
                "tourId=" + tourId +
                ", placeId=" + placeId +
                '}';
    }
}
