package pojo;

import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class TourDuration implements Initiable {
    private Integer id;
    private Integer numberDays;
    private String desc;

    public TourDuration() {
    }

    public TourDuration(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 3) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.id = (Integer) fields[0];
        this.numberDays = (Integer) fields[1];
        this.desc = (String) fields[2];
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
                ", numberDays=" + numberDays +
                ", desc='" + desc + '\'' +
                '}';
    }
}
