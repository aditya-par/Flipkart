package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static Long autoId=0L;
    Long userId;
    String name;
    String gender;
    Integer age;
    List<Vehicle> vehicles;
    int offeredRides = 0;
    int takenRides = 0;

    public User(String name, String gender, Integer age) {
        autoId++;
        this.userId = autoId;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicles = new ArrayList<>();
    }

    public User(String name, String gender, Integer age, List<Vehicle> vehicles) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.vehicles = vehicles;
    }

    public static Long getAutoId() {
        return autoId;
    }

    public static void setAutoId(Long autoId) {
        User.autoId = autoId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles = vehicles;
    }

    public int getOfferedRides() {
        return offeredRides;
    }

    public void setOfferedRides(int offeredRides) {
        this.offeredRides = offeredRides;
    }

    public int getTakenRides() {
        return takenRides;
    }

    public void setTakenRides(int takenRides) {
        this.takenRides = takenRides;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", vehicles=" + vehicles +
                ", offeredRides=" + offeredRides +
                ", takenRides=" + takenRides +
                '}';
    }
}
