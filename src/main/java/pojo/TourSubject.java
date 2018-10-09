package pojo;


import pojo.interfaces.Initiable;
import utils.exceptions.InvalidNumberOfArgumentsException;

public class TourSubject implements Initiable {
    private Integer tourId;
    private Integer subjectId;

    public TourSubject() {
    }

    public TourSubject(Object... fields) {
        init(fields);
    }

    @Override
    public void init(Object... fields) {
        if (fields == null || fields.length != 2) {
            throw new InvalidNumberOfArgumentsException();
        }
        this.tourId = (Integer) fields[0];
        this.subjectId = (Integer) fields[1];
    }

    public Integer getTourId() {
        return tourId;
    }

    public void setTourId(Integer tourId) {
        this.tourId = tourId;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public String toString() {
        return "TourSubject{" +
                "tourId=" + tourId +
                ", subjectId=" + subjectId +
                '}';
    }
}
