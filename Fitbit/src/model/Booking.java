package model;

public class Booking {

    private static Long autoId=0L;
    private Long id=0L;
    private Long userId;
    private String centerName;
    private String workoutType;
    private Long slotId;
    private String status;

    public Booking(Long userId, String centerName, String workoutType, Long slotId) {
        autoId++;
        this.id=autoId;
        this.userId = userId;
        this.centerName = centerName;
        this.workoutType = workoutType;
        this.slotId = slotId;
        this.status = "initiated";
    }
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public String getWorkoutType() {
        return workoutType;
    }

    public void setWorkoutType(String workoutType) {
        this.workoutType = workoutType;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "userId=" + userId +
                ", centerName='" + centerName + '\'' +
                ", workoutType='" + workoutType + '\'' +
                ", slotId=" + slotId +
                ", status='" + status + '\'' +
                ", id='" + id + '\'' +
                '}';
    }


    public Long getId() {
        return id;
    }

}