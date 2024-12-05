package model;

import java.util.ArrayList;
import java.util.List;

public class Center {

    private String name;
    private String city;
    private final List<Long> slots = new ArrayList<>();
    private Integer maxSlots;
    private List<String> daysClosedList;
    private final List<Workout> workouts = new ArrayList<>();

    public Center(String name, String city, List<String> daysClosedList, Integer slots) {
        this.name = name;
        this.city = city;
        this.daysClosedList=daysClosedList;
        this.maxSlots=slots;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<String> getDaysClosedList() {
        return daysClosedList;
    }

    public void setDaysClosedList(List<String> daysClosedList) {
        this.daysClosedList = daysClosedList;
    }
    public Integer getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(Integer maxSlots) {
        this.maxSlots = maxSlots;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Long> getSlots() {
        return slots;
    }

    public List<Workout> getWorkouts() {
        return workouts;
    }

    @Override
    public String toString() {
        return "Center{" +
                "name='" + name + '\'' +
                ", slots=" + slots +
                ", maxSlots=" + maxSlots +
                ", daysClosedList=" + daysClosedList +
                ", workouts=" + workouts +
                '}';
    }
}
