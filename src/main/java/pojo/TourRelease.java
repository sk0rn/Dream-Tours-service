package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

import java.sql.Timestamp;

public class TourRelease implements Initiable {
    private Integer id;
    private Integer tourId;
    private Integer tourDurationId;
    private java.sql.Timestamp beginTime;
    private Integer capacity;

    public TourRelease() {
    }

    public TourRelease(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 5) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.id = (Integer) fields[0];
        this.tourId = (Integer) fields[1];
        this.tourDurationId = (Integer) fields[2];
        this.beginTime = (Timestamp) fields[3];
        this.capacity = (Integer) fields[4];
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTourDurationId() {
        return tourDurationId;
    }

    public void setTourDurationId(Integer tourDurationId) {
        this.tourDurationId = tourDurationId;
    }

    public java.sql.Timestamp getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(java.sql.Timestamp beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "TourRelease{" +
                "id=" + id +
                ", tourId=" + tourId +
                ", tourDurationId=" + tourDurationId +
                ", beginTime=" + beginTime +
                ", capacity=" + capacity +
                '}';
    }
}
