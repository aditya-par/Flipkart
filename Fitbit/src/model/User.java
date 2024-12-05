package model;

public class User {

    private static Long autoId=0L;
    private Long userId=0L;
    private String name;
    private int age;

    private String city;

    public User(String name, int age, String city) {
        autoId++;
        this.userId=autoId;
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}