package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class Duration implements Initiable {
    private Integer id;
    private Integer numberDays;
    private String name;

    public Duration() {
    }

    public Duration(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 3) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.id = (Integer) fields[0];
        this.numberDays = (Integer) fields[1];
        this.name = (String) fields[2];
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNumberDays() {
        return numberDays;
    }

    public void setNumberDays(Integer numberDays) {
        this.numberDays = numberDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TourDuration{" +
                "id=" + id +
                ", numberDays=" + numberDays +
                ", name='" + name + '\'' +
                '}';
    }
}
