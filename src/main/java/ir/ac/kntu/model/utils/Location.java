package ir.ac.kntu.model.utils;

public class Location {
    private double latitude;
    private double longitude;
    private String address;

    public Location(double latitude, double longitude, String address) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
    }

    public Location() {

    }

    @Override
    public String toString() {
        return "Location{" +
                "latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

    public double distanceFrom(Location location) {
        double dist = Math.pow(getLatitude() - location.getLatitude(), 2) +
                Math.pow(getLongitude() - location.getLongitude(), 2);
        return Math.sqrt(dist);
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
