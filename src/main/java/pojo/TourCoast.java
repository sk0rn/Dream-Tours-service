package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class TourCoast implements Initiable {
    private Integer id;
    private Integer tourDurationId;
    private String kind;
    private Double coast;
    private Integer clippingAge;

    public TourCoast() {
    }

    public TourCoast(Object... fileds) {
        init();
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 5) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.id = (Integer) fields[0];
        this.tourDurationId = (Integer) fields[1];
        this.kind = (String) fields[2];
        this.coast = (Double) fields[3];
        this.clippingAge = (Integer) fields[4];
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

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public Double getCoast() {
        return coast;
    }

    public void setCoast(Double coast) {
        this.coast = coast;
    }

    public Integer getClippingAge() {
        return clippingAge;
    }

    public void setClippingAge(Integer clippingAge) {
        this.clippingAge = clippingAge;
    }

    @Override
    public String toString() {
        return "TourCoast{" +
                "id=" + id +
                ", tourDurationId=" + tourDurationId +
                ", kind='" + kind + '\'' +
                ", coast=" + coast +
                ", clippingAge=" + clippingAge +
                '}';
    }
}
