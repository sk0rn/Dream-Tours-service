package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class TourDuration implements Initiable {
    private Integer id;
    private Integer tourId;
    private Integer numberDays;
    private String desc;

    public TourDuration() {
    }

    public TourDuration(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 4) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.id = (Integer) fields[0];
        this.tourId = (Integer) fields[1];
        this.numberDays = (Integer) fields[2];
        this.desc = (String) fields[3];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getNumberDays() {
        return numberDays;
    }

    public void setNumberDays(Integer numberDays) {
        this.numberDays = numberDays;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "TourDuration{" +
                "id=" + id +
                ", tourId=" + tourId +
                ", numberDays=" + numberDays +
                ", desc='" + desc + '\'' +
                '}';
    }
}
