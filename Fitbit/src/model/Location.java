package model;

public class Location {

    private String city;
    private Double lat;
    private Double lon;

    public Location(String city, Double lat, Double lon) {
        this.city = city;
        this.lat = lat;
        this.lon = lon;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
