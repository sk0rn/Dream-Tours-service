package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class Contact implements Initiable {
    private Integer id;
    private Integer clientId;
    private String value;

    public Contact() {
    }

    public Contact(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 3) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.id = (Integer) fields[0];
        this.clientId = (Integer) fields[1];
        this.value = (String) fields[2];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", value='" + value + '\'' +
                '}';
    }
}
