package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class TourCoast implements Initiable {
    private Integer id;
    private Integer tourDurationId;
    private Boolean kind;
    private Double coast;
    private Integer clippingAge;
    private Boolean isParticipant;

    public TourCoast() {
    }

    public TourCoast(Object... fileds) {
        init(fileds);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 6) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.id = (Integer) fields[0];
        this.tourDurationId = (Integer) fields[1];
        this.kind = (Boolean) fields[2];
        this.coast = (Double) fields[3];
        this.clippingAge = (Integer) fields[4];
        this.isParticipant = (Boolean) fields[5];
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

    public Boolean getKind() {
        return kind;
    }

    public void setKind(Boolean kind) {
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

    public Boolean getParticipant() {
        return isParticipant;
    }

    public void setParticipant(Boolean participant) {
        isParticipant = participant;
    }

    @Override
    public String toString() {
        return "TourCoast{" +
                "id=" + id +
                ", tourDurationId=" + tourDurationId +
                ", kind=" + kind +
                ", coast=" + coast +
                ", clippingAge=" + clippingAge +
                ", isParticipant=" + isParticipant +
                '}';
    }
}
