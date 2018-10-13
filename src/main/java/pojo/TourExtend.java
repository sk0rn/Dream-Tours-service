package pojo;

import java.util.ArrayList;
import java.util.List;

public class TourExtend {

    private Tour tour;
    private List<Place> places;
    private List<Subject> subjects;

    public TourExtend(Tour tour) {
        this.tour = tour;
        places = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public void setPlaces(List<Place> places) {
        this.places = places;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    public void info() {
        System.out.println(toString());
        places.forEach(System.out::println);
        subjects.forEach(System.out::println);

    }

    @Override
    public String toString() {
        return "TourExtend{" +
                "tour=" + tour +
                '}';
    }
}
