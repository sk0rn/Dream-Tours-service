package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class Order implements Initiable {
    private Integer id;
    private Integer userId;
    private Integer tourReleaseId;
    private Double coast;
    private Integer status;

    public Order() {
    }

    public Order(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 5) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.id = (Integer) fields[0];
        this.userId = (Integer) fields[1];
        this.tourReleaseId = (Integer) fields[2];
        this.coast= (Double) fields[3];
        this.status= (Integer) fields[4];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTourReleaseId() {
        return tourReleaseId;
    }

    public void setTourReleaseId(Integer tourReleaseId) {
        this.tourReleaseId = tourReleaseId;
    }

    public Double getCoast() {
        return coast;
    }

    public void setCoast(Double coast) {
        this.coast = coast;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", tourReleaseId=" + tourReleaseId +
                ", coast=" + coast +
                ", status=" + status +
                '}';
    }
}
