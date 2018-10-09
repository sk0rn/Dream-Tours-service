package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class Participant implements Initiable {
    private Integer id;
    private Integer orderId;
    private Integer clippingAge;
    private Integer quantity;

    public Participant() {

    }

    public Participant(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 4) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.id = (Integer) fields[0];
        this.orderId = (Integer) fields[1];
        this.clippingAge = (Integer) fields[2];
        this.quantity = (Integer) fields[3];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }


    public Integer getClippingAge() {
        return clippingAge;
    }

    public void setClippingAge(Integer clippingAge) {
        this.clippingAge = clippingAge;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Participant{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", clippingAge=" + clippingAge +
                ", quantity=" + quantity +
                '}';
    }
}
