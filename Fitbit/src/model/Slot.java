package model;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Slot {

    private static Long autoId=0L;
    private Long id=0L;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String workoutType;
    private int availableSeats;
    private int totalSeats;

    public Queue<Long> getWailingList() {
        return wailingList;
    }

    public void setWailingList(Queue<Long> wailingList) {
        this.wailingList = wailingList;
    }

    private Queue<Long> wailingList;

    public Slot(LocalDateTime startTime, LocalDateTime endTime, int totalSeats, String workoutType) {
        autoId++;
        this.id=autoId;
        this.startTime = startTime;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
        this.workoutType = workoutType;
        this.endTime = endTime;
        this.wailingList = new LinkedList<>();
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    @Override
    public String toString() {
        return "Slot{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                ", workoutType='" + workoutType + '\'' +
                ", availableSeats=" + availableSeats +
                ", totalSeats=" + totalSeats +
                ", wailingList=" + wailingList +
                '}';
    }
}
