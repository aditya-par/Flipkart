package model;

public class Workout {
    private String type;

    private static int Id;

    public Workout(String type) {
        this.type = type;
        Id++;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public static int getId() {
        return Id;
    }

    public static void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Workout{" +
                "type='" + type + '\'' +
                '}';
    }

}
