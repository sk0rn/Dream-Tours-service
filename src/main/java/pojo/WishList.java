package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class WishList implements Initiable {
    private Integer clientId;
    private Integer tourId;

    public WishList() {
    }

    public WishList(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 2) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.clientId = (Integer) fields[0];
        this.tourId = (Integer) fields[1];
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    @Override
    public String toString() {
        return "WishList{" +
                "clientId=" + clientId +
                ", tourId=" + tourId +
                '}';
    }
}
