package ir.ac.kntu.delivery;

import java.util.ArrayList;
import ir.ac.kntu.time.*;
import ir.ac.kntu.services.*;


public class Delivery {
    private String id;
    private VehicleType vehicleType;
    private WageType wageType;
    private double paycheck;
    // i guess rating Delivery is quite absurd so fuck it
    private Order activeOrder;
    private Restaurant restaurant1;
    private Restaurant restaurant2;
    private ArrayList <Order> orderHistory;
    private Schedule schedule;

    public Delivery(VehicleType vehicleType, WageType wageType, Restaurant restaurant1, Restaurant restaurant2, Schedule schedule) {
        this.vehicleType = vehicleType;
        this.wageType = wageType;
        this.restaurant1 = restaurant1;
        this.restaurant2 = restaurant2;
        this.schedule = schedule;
        this.id = getAlphaNumericString(5);
        this.paycheck = 0.0;
        this.orderHistory = new ArrayList<>();
        activeOrder = null;
    }



    public String getAlphaNumericString(int n) {
        String alphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789";
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {

            int index = (int) (alphaNumericString.length() * Math.random());
            sb.append(alphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public WageType getWageType() {
        return wageType;
    }

    public void setWageType(WageType wageType) {
        this.wageType = wageType;
    }

    public double getPaycheck() {
        return paycheck;
    }

    public void setPaycheck(double paycheck) {
        this.paycheck = paycheck;
    }

    public Order getActiveOrder() {
        return activeOrder;
    }

    public void setActiveOrder(Order activeOrder) {
        this.activeOrder = activeOrder;
    }

    public Restaurant getRestaurant1() {
        return restaurant1;
    }

    public void setRestaurant1(Restaurant restaurant1) {
        this.restaurant1 = restaurant1;
    }

    public Restaurant getRestaurant2() {
        return restaurant2;
    }

    public void setRestaurant2(Restaurant restaurant2) {
        this.restaurant2 = restaurant2;
    }

    public ArrayList<Order> getOrderHistory() {
        return orderHistory;
    }

    public void setOrderHistory(ArrayList<Order> orderHistory) {
        this.orderHistory = orderHistory;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }
}